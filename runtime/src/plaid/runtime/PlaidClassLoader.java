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
 
package plaid.runtime;

import java.util.List;

import plaid.runtime.utils.Delegate;
import plaid.runtime.utils.Import;
import plaid.runtime.utils.Lambda;



public interface PlaidClassLoader {
	/**
	 * Method to retrieve PlaidClass object for corresponding class.
	 * 
	 * @param name
	 * @param thisVar
	 * @return
	 * @throws PlaidClassNotFoundException
	 */
	public PlaidObject lookup(String name, PlaidObject thisVar) throws PlaidException;
	
	/**
	 * Method to retrieve PlaidClass object for corresponding class.
	 * 
	 * @param name
	 * @param currentScope
	 * @return
	 * @throws PlaidClassNotFoundException
	 */
	public PlaidObject lookup(String name, PlaidScope currentScope) throws PlaidException;
	
	/**
	 * Method to create a PlaidJavaObject.  
	 * 
	 * @param o
	 * @return
	 * @throws PlaidException
	 */
	public PlaidJavaObject packJavaObject(Object o) throws PlaidException;
	
	/**
	 * Create a new anonymous PlaidMethod object (aka lambda) that 
	 * has pthis of unit;
	 * 
	 * @param fn
	 * @return new PlaidMethod that can be invoked  
	 * @throws PlaidException
	 */
	public PlaidMethod lambda(Lambda fn) throws PlaidException;
	
	/**
	 * Create a new PlaidMethod object that 
	 * does not have this bound yet;
	 * 
	 * @param fn
	 * @return new PlaidMethod that must be instantiated before being invoked  
	 * @throws PlaidException
	 */
	public PlaidMethod protoMethod(Delegate fn) throws PlaidException;
	
	/**
	 * Create a new PlaidMethod object that 
	 * does not have this bound yet;
	 * 
	 * @param fn
	 * @return new PlaidMethod that must be instantiated before being invoked  
	 * @throws PlaidException
	 */
	public PlaidMethod protoField(Delegate fn) throws PlaidException;
	
	/**
	 * Method to return unit object.
	 * 
	 * @return
	 * @throws PlaidException
	 */
	public PlaidObject unit() throws PlaidException;
	
	/**
	 * @param qi Package name in standard dotted-name form.
	 * @return PlaidScope representing package.
	 * @throws PlaidException
	 */
	public PlaidScope packageScope(String qi, List<Import> imports) throws PlaidException;
	
	/**
	 * @param currentScope
	 * @param thisVar
	 * @return
	 */
	public PlaidScope lambdaScope(PlaidScope currentScope, PlaidObject thisVar);
}
