/**
 * Project: Assignment1
 * File: CompareByCountDescending.java
 * Date: May 18, 2017
 * Time: 10:02:10 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByCountDescending implements Comparator<Inventory> {

	@Override
	public int compare(Inventory inventory1, Inventory inventory2) {
		return inventory2.getQuantity() - inventory1.getQuantity();
	}
}
