package plaid.parser.ast;

import java.util.Set;

public class UnpackInnerGroups implements Expression {
		private final Token token;
        private final Expression body;

        public UnpackInnerGroups(Token token, Expression body) {
                super();
                this.token = token;
                this.body = body;
        }

        @Override
        public void codegenExpr(CodeGen out, ID y, IDList localVars,  Set<ID> stateVars) {
        	body.codegenExpr(out, y, localVars, stateVars);
        }

        @Override
        public boolean hasToken() {
                return true;
        }

        @Override
        public Token getToken() {
                return token;
        }

        public Expression getBody() {
			return body;
		}

		@Override
        public <T> T accept(ASTVisitor<T> visitor) {
        	return visitor.visitNode(this);
        }
        
        @Override
        public <T> void visitChildren(ASTVisitor<T> visitor) {
             body.accept(visitor);
        }

}
        
        
