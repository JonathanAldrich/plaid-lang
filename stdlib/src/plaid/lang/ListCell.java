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
 *  but WITHOUT ANY WARRANTY;
 without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License 
 *  along with Plaid Programming Language.  If not, see <http://www.gnu.org/licenses/>.
 */

package plaid.lang;
@plaid.runtime.annotations.RepresentsState(name = "ListCell", toplevel = true)
public class ListCell{
	public static final java.util.List<plaid.runtime.utils.Import> vAr31$plaid;
	static {
		vAr31$plaid = new java.util.ArrayList<plaid.runtime.utils.Import>();
		vAr31$plaid.add(new plaid.runtime.utils.Import("plaid.lang.*"));
	}
	public static final plaid.runtime.PlaidScope current$c0pe = plaid.runtime.PlaidRuntime.getRuntime().getClassLoader().packageScope("plaid.lang",vAr31$plaid);
	@plaid.runtime.annotations.RepresentsState(name = "ListCell", toplevel = false)
	public static final plaid.runtime.PlaidObject ListCell;
	static {
		final plaid.runtime.PlaidState vAr32$plaid;
		vAr32$plaid = plaid.runtime.Util.newState();
		ListCell = vAr32$plaid.getPrototype();
	}
}
