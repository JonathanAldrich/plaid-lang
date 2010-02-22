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
import plaid.compilerjava.util.IdGen;

public class Case {
	private Token token;
	private QI qi;
	private ID x;
	private Expression e;
	
	public Case(QI qi, ID x, Expression e) {
		super();
		this.qi = qi;
		this.x = x;
		this.e = e;
	}

	public Case(Token t, QI qi, ID x, Expression e) {
		super();
		this.token = t;
		this.qi = qi;
		this.x = x;
		this.e = e;
	}
	
	public QI getQi() {
		return qi;
	}

	public void setQi(QI qi) {
		this.qi = qi;
	}

	public ID getX() {
		return x;
	}

	public void setX(ID x) {
		this.x = x;
	}

	public Expression getE() {
		return e;
	}

	public void setE(Expression e) {
		this.e = e;
	}

	public Token getToken() {
		return token;
	}
	
	public void codegen(CodeGen out, ID y, ID toMatch, List<ID> localVars) {
		
		out.setLocation(token);
		
		// if this is the default case
		if (qi == null && x == null) {
			out.ifCondition("true"); //if (true)
			out.addBlock(); //{
			e.codegen(out, y, localVars);
			out.closeBlock(); // }
			return;
		}
		
		// otherwise generate code execute associated code if this case matches
		ID potentialMatch = IdGen.getId();
		out.declareVar(CodeGen.plaidObjectType,potentialMatch.getName());
		qi.codegen(out, potentialMatch, localVars);
		
		out.ifCondition(CodeGen.matchesState(toMatch.getName(),potentialMatch.getName()));  //if (toMatch.hasState(potentialMatch))
		out.addBlock(); // {
		out.declareFinalVar(CodeGen.plaidObjectType, x.getName()); //PlaidObject x;
		out.assignToID(x.getName(),toMatch.getName()); // x = toMatch
		localVars.add(x);
		e.codegen(out, y, localVars);
		localVars.remove(x);
		out.closeBlock(); // }
	}
}
