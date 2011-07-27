package plaid.parser.ast;

import java.util.List;

import plaid.parser.Token;

public class StateRef extends StatePrim {
	private final Expression state;
	private final List<DeclOrStateOp> specializations;
	
	public StateRef(Token t, Expression state,
			List<DeclOrStateOp> specializations) {
		super(t);
		this.state = state;
		this.specializations = specializations;
	}

	public Expression getState() {
		return state;
	}

	public List<DeclOrStateOp> getSpecializations() {
		return specializations;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(state.toString());
		if ( specializations.size() > 0 ) {
			sb.append("{" + specializations.get(0));
			for(int i = 1; i<specializations.size(); i++) {
				sb.append(specializations.get(i));
			}
			sb.append("}");
		}
		return sb.toString();
	}
	
}
