package plaid.parser.ast;

public class GroupType implements TypeDecl, MetaType {
	private final Identifier id;
	private final GroupPermission groupPermission;
	private final boolean isAbstract;

	public GroupType(GroupPermission groupPermission, Identifier id, boolean isAbstract) {
		this.groupPermission = groupPermission;
		this.isAbstract = isAbstract;
		this.id = id;
	}

	//      @Override
	//      public <T> T accept(ASTVisitor<T> visitor) {
	//              return visitor.visitNode(this);
	//      }
	//
	//      @Override
	//      public Token getToken() {
	//              // TODO Auto-generated method stub
	//              return null;
	//      }
	//
	//      @Override
	//      public boolean hasToken() {
	//              return false;
	//      }
	//
	//      @Override
	//      public <T> void visitChildren(ASTVisitor<T> visitor) {
	//              this.permType.accept(visitor);
	//      }


	public Identifier getID() {
		return this.id;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public GroupPermission getGroupPermission() {
		return groupPermission;
	}
	
	@Override
	public String toString() {
		return "group " + id + ((isAbstract)?"":" = new group");
	}

}
