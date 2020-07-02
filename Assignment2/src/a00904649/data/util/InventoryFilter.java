/**
 * Project: Assignment2
 * File: InventoryFilter.java
 * Date: Jul 1, 2017
 * Time: 12:57:34 PM
 */

package a00904649.data.util;

import java.util.ArrayList;
import java.util.List;

import a00904649.ApplicationException;
import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class InventoryFilter {
	private static final int SUB = 5;

	private InventoryFilter() {
	}

	public static List<Inventory> filterInventory(List<Inventory> inven) throws ApplicationException {
		List<Inventory> filteredList = new ArrayList<>();
		for (Inventory inventory : inven) {
			if (inventory.getMotorcycleId().substring(0, SUB).equalsIgnoreCase("Honda")) {
				filteredList.add(inventory);
			}
		}
		return filteredList;
	}
}
