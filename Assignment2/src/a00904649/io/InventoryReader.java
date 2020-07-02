/**
 * Project: Assignment2
 * File: InventoryReader.java
 * Date: May 13, 2017
 * Time: 3:25:10 PM
 */

package a00904649.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class InventoryReader {

	private static final Logger LOG = LogManager.getLogger();
	public static final String FIELD_DELIMITER = "\\|";
	public static final String FILE_NAME = "inventory.dat";
	public static final int PRICE = 100;

	/**
	 * private constructor to prevent instantiation
	 */
	private InventoryReader() {
	}

	/**
	 * Read the Inventory input data from inventory.dat file.
	 * 
	 * @return inventoryList
	 *         the list of Inventory.
	 * @throws ApplicationException
	 */
	public static List<Inventory> readInventoryFile() throws ApplicationException {

		BufferedReader input = null;
		String[] inventoryArray = new String[Inventory.INVENTORY_SIZE];
		List<Inventory> inventoryList = new ArrayList<>();
		try {
			input = new BufferedReader(new FileReader(FILE_NAME));
			LOG.debug("Reading inventory data from " + FILE_NAME);
			@SuppressWarnings("unused")
			// to store the first line of the unused data.
			String firstLine = input.readLine();

			while (input.ready()) {
				int i = 0;
				inventoryArray[i] = input.readLine();
				Inventory inven = readInventoryString(inventoryArray[i]);
				inventoryList.add(inven);
				i++;
			}
			LOG.debug("Inventory items added to ArrayList");
			input.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("%s does not exist", FILE_NAME));
		}
		return inventoryList;
	}

	/**
	 * Parse inventory data string into a Inventory object;
	 * 
	 * @param row
	 *            String of inventory data.
	 * @return inventory
	 * @throws ApplicationException
	 */

	private static Inventory readInventoryString(String row) throws ApplicationException {

		String[] elements = row.split(FIELD_DELIMITER);
		if (elements.length != Inventory.ATTRIBUTE_COUNT) {
			throw new ApplicationException(
					String.format("Expected %d but got %d: %s", Inventory.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		String id = elements[index++];
		String description = elements[index++];
		String partNumber = elements[index++];
		double price = Double.parseDouble(elements[index++]) / PRICE;
		String quantity = elements[index++];

		Inventory inventory = new Inventory(id, description, partNumber, price, quantity);
		LOG.debug("Inventory with part number " + inventory.getPartNumber() + " created");
		return inventory;
	}
}
