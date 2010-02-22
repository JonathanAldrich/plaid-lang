/**
 * Copyright (c) 2010 The PlaidGroup (see AUTHORS file)
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
 
package plaid.compilerjava.AST;

import java.util.List;

import plaid.compilerjava.coreparser.Token;
import plaid.compilerjava.util.CodeGen;

public class IntLiteral implements Expression {

	private Token token;
	private int integer;
	
	@Override
	public void codegen(CodeGen out, ID y, List<ID> localVars) {
		out.setLocation(token);
		out.assign(y.getName());
		out.plaidInt(integer);
		out.append(";");
		out.updateVar(y.getName());
	}
	
	public IntLiteral(int integer) {
		super();
		this.integer = integer;
	}

	public IntLiteral(Token t, int integer) {
		super();
		this.token = t;
		this.integer = integer;
	}
	
	public Token getToken() {
		return token;
	}
	
	@Override
	public String toString() {
		return ""+integer;
	}
}
