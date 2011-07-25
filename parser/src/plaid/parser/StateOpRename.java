package plaid.parser;

import plaid.parser.ast.Identifier;

public class StateOpRename extends StateOp {
	protected final Identifier from;
	protected final Identifier to;
	
	public StateOpRename(Token token, Identifier from, Identifier to) {
		super(token);
		this.from = from;
		this.to = to;
	}
	
	public final Identifier getFrom() {
		return from;		
	}
	
	public final Identifier getTo() {
		return to;
	}

}
