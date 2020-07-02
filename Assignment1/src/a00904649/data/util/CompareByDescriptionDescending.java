/**
 * Project: Assignment1
 * File: CompareByDescriptionDescending.java
 * Date: May 18, 2017
 * Time: 9:55:58 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByDescriptionDescending implements Comparator<Inventory> {

	@Override
	public int compare(Inventory inventory1, Inventory inventory2) {
		return inventory2.getDescription().compareTo(inventory1.getDescription());
	}
}
