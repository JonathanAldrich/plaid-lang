package plaid.fastruntime.dcg;

import java.util.ArrayList;
import java.util.Collection;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import plaid.fastruntime.MethodInfo;
import plaid.fastruntime.ObjectValue;
import plaid.fastruntime.PlaidState;


public final class DispatchGenerator implements Opcodes {
	private int classCounter = 0;
	private final DynClassLoader cl = new DynClassLoader();
	
	public PlaidState createClass(ObjectValue ov) {
		final String name = "plaid/generatedDispatches/DispatchClass$plaid$"+classCounter++;
					
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
		
		// generate class
		Collection<String> ifaces = new ArrayList<String>();
		for (MethodInfo m : ov.getMethods()) {
			ifaces.add(NamingConventions.getGeneratedInterfaceInternalName(m.getName()));
		}
		cw.visit(50,
			     ACC_PUBLIC,
			     name,
			     null,
			     "plaid/fastruntime/AbstractPlaidState",
			     ifaces.toArray(new String[0]));
		
		// add methods 
		for ( MethodInfo m : ov.getMethods() ) {
			//System.out.println("add method: " + m.getName());
			MethodVisitor mv;
			mv = cw.visitMethod(ACC_PUBLIC, 
					m.getName(), 
					m.getMethodDescriptor(),
					null,
					null); // TODO: add exception
					mv.visitCode();
					// add receiver

					mv.visitVarInsn(Opcodes.ALOAD, 0);
					// add parameters
					for (int x = 1; x <= m.numArgs(); x++ ) {
						mv.visitVarInsn(Opcodes.ALOAD, x);
					}
					mv.visitMethodInsn(INVOKESTATIC, m.getStaticClassInternalName(), m.getName(), m.getMethodDescriptor());
					mv.visitInsn(RETURN);
					mv.visitMaxs(0,0);
					mv.visitEnd();			
		}
		
		
		// add constructor
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(Opcodes.ALOAD, 0);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object","<init>", "()V");
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(0,0);
		mv.visitEnd();

		// done
		cw.visitEnd();
		PlaidState result = null;
		try {
			result =  (PlaidState)cl.createClass(name, cw).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	private class DynClassLoader extends ClassLoader {
		public Class<?> createClass(String name, ClassWriter cw) {
			byte[] b = cw.toByteArray();
			return defineClass(name.replace("/", "."), b, 0, b.length);
		}
	}
}
