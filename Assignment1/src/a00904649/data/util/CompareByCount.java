/**
 * Project: Assignment1
 * File: CompareByCount.java
 * Date: May 14, 2017
 * Time: 5:47:33 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByCount implements Comparator<Inventory> {

	@Override
	public int compare(Inventory inventory1, Inventory inventory2) {
		return inventory1.getQuantity() - inventory2.getQuantity();
	}
}
