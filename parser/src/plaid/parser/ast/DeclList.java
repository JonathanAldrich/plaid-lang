/**
 * Copyright (c) 2010 The Plaid Group (see AUTHORS file)
 * 
 * This file is part of Plaid Programming Language.
 *
 * Plaid Programming Language is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 *  Plaid Programming Language is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Plaid Programming Language.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package plaid.parser.ast;

import java.util.List;

import plaid.parser.Token;

public class DeclList extends StatePrim {

	private List<Decl> decls;

	public DeclList(Token t, List<Decl> decls) {
		super(t);
		this.decls = decls;
	}

	public List<Decl> getDecls() {
		return decls;
	}

	public void setDecls(List<Decl> decls) {
		this.decls = decls;
	}
	
	@Override
	public boolean equivalent(ASTNode other) {
		if(other instanceof DeclList) {
			DeclList otherDL = (DeclList) other;
			for(int i=0; i<decls.size(); i++) {
				if(!decls.get(i).equivalent(otherDL.decls.get(i)))
					return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
}
