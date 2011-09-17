package plaid.parser.ast;

public final class EmptyType extends TypeDeclaration {
	private final static EmptyType singleton = new EmptyType();
	
	private EmptyType() {
		super(DEFAULT_TOKEN);
	}
	
	protected static EmptyType getEmptyType() {
		return singleton;
	}
}
