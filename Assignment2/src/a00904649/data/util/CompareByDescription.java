/**
 * Project: Assignment2
 * File: CompareByDescription.java
 * Date: May 17, 2017
 * Time: 11:34:34 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByDescription implements Comparator<Inventory> {

	@Override
	public int compare(Inventory inventory1, Inventory inventory2) {
		return inventory1.getDescription().compareTo(inventory2.getDescription());
	}
}
