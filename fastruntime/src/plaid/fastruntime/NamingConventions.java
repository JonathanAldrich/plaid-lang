package plaid.fastruntime;

import fj.P2;
import fj.data.List;


public class NamingConventions {
	
	public static final String GENERATED_PKG = "plaid/generated";
	public static final String GENERATED_INTERFACES_PREFIX = "I";
	public static final String GENERATED_VARIABLE_PREFIX = "VaR";
	public static final String GENERATED_STORAGE_PREFIX = "S";
	public static final String GENERATED_SUFFIX = "$plaid";
	public static final String GENERATED_DIR = "../generated/bin/" + GENERATED_PKG;
	public static final String GENERATED_METHOD_NAME = "invoke" + GENERATED_SUFFIX;
	public static final String GENERATED_STATE_NAME = "theState" + GENERATED_SUFFIX;
	public static final String GENERATED_THIS = "this" + GENERATED_SUFFIX;
	public static final String GENERATED_GET_PREFIX = "get";
	public static final String GENERATED_SET_PREFIX = "set";
	
	public static final String PLAID_OBJECT_INTERNAL_NAME = "plaid/fastruntime/PlaidObject";
	public static final String PLAID_OBJECT_DESCRIPTOR = "L" + PLAID_OBJECT_INTERNAL_NAME + ";";
	public static final String PLAID_JAVA_OBJECT_INTERNAL_NAME = "plaid/fastruntime/PlaidJavaObject";
	public static final String PLAID__JAVA_OBJECT_DESCRIPTOR = "L" + PLAID_JAVA_OBJECT_INTERNAL_NAME + ";";
	public static final String JAVA_OBJECT_INTERNAL_NAME = "java/lang/Object";
	public static final String JAVA_OBJECT_DESCRIPTOR = "L" + JAVA_OBJECT_INTERNAL_NAME + ";";
	public static final String JAVA_STRING_INTERNAL_NAME = "java/lang/String";
	public static final String JAVA_STRING_DESCRIPTOR = "L" + JAVA_STRING_INTERNAL_NAME + ";";
	
	
	public static final String getGetterName(String fieldName) {
		return GENERATED_GET_PREFIX + fieldName + GENERATED_SUFFIX;
	}
	
	public static final String getSetterName(String fieldName) {
		return GENERATED_SET_PREFIX + fieldName + GENERATED_SUFFIX;
	}
	
	public static final String getGeneratedInterfaceSimpleName(String method, int numArgs) {
		return GENERATED_INTERFACES_PREFIX + 
		method + "$" + numArgs +
		GENERATED_SUFFIX;
	}
	
	
	public static final String getGeneratedStorageSimpleName(List<P2<Boolean, String>> fields) {
		StringBuilder storageName = new StringBuilder(GENERATED_STORAGE_PREFIX);
		for(P2<Boolean,String> field : fields) {
			if(field._1()) {
				storageName.append("t");
			} else {
				storageName.append("f");
			}
			storageName.append(field._2());
		}
		storageName.append(GENERATED_SUFFIX);
		return storageName.toString();
	}
	
	public static final String getGeneratedInterfaceInternalName(String method, int numArgs) {
		return GENERATED_PKG + "/" + 
		getGeneratedInterfaceSimpleName(method, numArgs);
	}
	
	public static final String getGeneratedInterfaceFullyQualifiedName(String method, int numArgs) {
		return getGeneratedInterfaceInternalName(method, numArgs).replace('/', '.');
	}
	
	public static final String getGeneratedStorageInternalName(List<P2<Boolean, String>> fields) {
		return GENERATED_PKG + "/" + 
		getGeneratedStorageSimpleName(fields);
	}
	
	public static final String getGeneratedInterfaceName(String method, int numArgs) {
		return getGeneratedInterfaceInternalName(method, numArgs).replace('/', '.');
	}
	
	public static final String getGeneratedStorageName(List<P2<Boolean, String>> fields) {
		return getGeneratedStorageInternalName(fields) .replace('/', '.');
	}
	
	public static final String getGeneratedInterfaceFilePath(String method, int numArgs) {
		return GENERATED_DIR + "/" + getGeneratedInterfaceSimpleName(method, numArgs) + ".class";
	}
	
	public static final String getIdentifierName(String sourceID) {
		return sourceID + "$plaid";
	}
	
	/*Generate Method Descriptors*/
	
	//Generates method descriptor for function that takes in PlaidObjects and returns a PlaidObject
	public static final String getMethodDescriptor(int numArgs) {
		return getMethodDescriptor(numArgs, PLAID_OBJECT_DESCRIPTOR, PLAID_OBJECT_DESCRIPTOR);
	}
	
	public static final String getMethodDescriptor(int numArgs, String argDescriptor, String retDescriptor) {
		StringBuilder sb = new StringBuilder("(");
		for(int i=0; i<numArgs; i++) {
			sb.append(argDescriptor); //args
		}
		sb.append(")");
		sb.append(retDescriptor); // return
		return sb.toString();
	}
	
	public static final String getMethodDescriptor(String firstArgDescriptor, int numArgs, String argDescriptor, String retDescriptor) {
		String start = getMethodDescriptor(numArgs, argDescriptor, retDescriptor);
		return start.replace("(", "("+firstArgDescriptor);
	}
	
	public static final String getMethodDescriptor(String firstArgDescriptor, String secondArgDescriptor, int numArgs, String argDescriptor, String retDescriptor) {
		String start = getMethodDescriptor(numArgs, argDescriptor, retDescriptor);
		String next = start.replace("(", "("+secondArgDescriptor);
		return next.replace("(", "("+firstArgDescriptor);
	}
	
	public static final String internalNameToDescriptor(String internalName) {
		return "L" + internalName + ";";
	}
	
	public static final String staticOverloadCallMethodDescriptor(int numArgs) {
		return getMethodDescriptor(JAVA_OBJECT_DESCRIPTOR, JAVA_STRING_DESCRIPTOR, numArgs, JAVA_OBJECT_DESCRIPTOR, JAVA_OBJECT_DESCRIPTOR);
	}
	

	
	
}
