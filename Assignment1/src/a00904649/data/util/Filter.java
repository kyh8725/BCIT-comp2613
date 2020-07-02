/**
 * Project: Assignment1
 * File: Filter.java
 * Date: May 19, 2017
 * Time: 7:02:16 PM
 */

package a00904649.data.util;

import java.util.ArrayList;
import java.util.List;

import a00904649.ApplicationException;
import a00904649.data.Inventory;
import a00904649.io.InventoryReader;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Filter {

	private static final int SUB = 5;

	public static List<Inventory> filterInventory(List<Inventory> inven) throws ApplicationException {
		List<Inventory> List = InventoryReader.readInventoryFile();
		List<Inventory> filteredList = new ArrayList<>();
		for (Inventory inventory : List) {
			if (inventory.getId().substring(0, SUB).equalsIgnoreCase("Honda")) {
				filteredList.add(inventory);
			}
		}
		return filteredList;
	}
}
