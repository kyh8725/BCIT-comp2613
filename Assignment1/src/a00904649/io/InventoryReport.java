/**
 * Project: Assignment1
 * File: InventoryReport.java
 * Date: May 13, 2017
 * Time: 3:26:03 PM
 */

package a00904649.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.BcmcOption;
import a00904649.data.Inventory;
import a00904649.data.util.CompareByCount;
import a00904649.data.util.CompareByCountDescending;
import a00904649.data.util.CompareByDescription;
import a00904649.data.util.CompareByDescriptionDescending;
import a00904649.data.util.Filter;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class InventoryReport {

	private static final Logger LOG = LogManager.getLogger();
	public static final String HORIZONTAL_LINE = "------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%-30s %-30s %-12s %10s %10s%n";
	public static final String HEADERTOTAL_FORMAT = "%-30s %-30s %-12s %10s %10s %10s%n";
	public static final String INVENTORY_FORMAT = "%-30s %-30s %-12s %,10.2f %,10d%n";
	public static final String INVENTORYTOTAL_FORMAT = "%-30s %-30s %-12s %10s %10s %,10.2f%n";
	public static final String FILEOUT = "inventory_report.txt";

	/**
	 * private constructor to prevent instantiation
	 */
	private InventoryReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param inven
	 *            a list of Inventory.
	 * @throws ApplicationException
	 */
	public static void writeInventory(List<Inventory> inven) throws ApplicationException {

		if (BcmcOption.isFilterOption()) {
			inven = Filter.filterInventory(inven);
			LOG.info("Inventory data filtered - Honda");
		}
		if (BcmcOption.IsDescriptionOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByDescriptionDescending());
				LOG.info("Inventory data sorted by Description descending order");
			} else {
				Collections.sort(inven, new CompareByDescription());
				LOG.info("Inventory data sorted by Description ascending order");
			}
		}
		if (BcmcOption.IsCountOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByCountDescending());
				LOG.info("Inventory data sorted by Quantity descending order");
			} else {
				Collections.sort(inven, new CompareByCount());
				LOG.info("Inventory data sorted by Quantity ascending order");
			}
		}

		System.out.println("Inventory Report");
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "Make+Model", "Description", "Part#", "Price", "Quantity");
		System.out.println(HORIZONTAL_LINE);

		for (Inventory inventory : inven) {
			System.out.format(INVENTORY_FORMAT, inventory.getId(), inventory.getDescription(), inventory.getPartNumber(), inventory.getPrice(),
					inventory.getQuantity());
		}
		LOG.info("Inventory report created and displayed");
	}

	/**
	 * Print the report.
	 * 
	 * @param inven
	 *            a list of Inventory with Total.
	 * @throws ApplicationException
	 */
	public static void writeInventoryTotal(List<Inventory> inven) throws ApplicationException {

		if (BcmcOption.isFilterOption()) {
			inven = Filter.filterInventory(inven);
			LOG.info("Inventory data filtered - Honda");
		}
		if (BcmcOption.IsDescriptionOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByDescriptionDescending());
				LOG.info("Inventory data sorted by Description descending order");
			} else {
				Collections.sort(inven, new CompareByDescription());
				LOG.info("Inventory data sorted by Description ascending order");
			}
		}
		if (BcmcOption.IsCountOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByCountDescending());
				LOG.info("Inventory data sorted by Quantity descending order");
			} else {
				Collections.sort(inven, new CompareByCount());
				LOG.info("Inventory data sorted by Quantity ascending order");
			}
		}

		System.out.println("Inventory Report");
		System.out.println(HORIZONTAL_LINE + "-----------");
		System.out.format(HEADERTOTAL_FORMAT, "Make+Model", "Description", "Part#", "Price", "Quantity", "Value");
		System.out.println(HORIZONTAL_LINE + "-----------");
		double total = 0;

		for (Inventory inventory : inven) {
			double totalTemp = inventory.getQuantity() * inventory.getPrice();
			System.out.format(INVENTORYTOTAL_FORMAT, inventory.getId(), inventory.getDescription(), inventory.getPartNumber(), inventory.getPrice(),
					inventory.getQuantity(), totalTemp);
			total = total + totalTemp;
		}

		System.out.format("Value of current inventory: $%,.2f%n", total);
		LOG.info("Inventory report with total created and displayed");
	}

	/**
	 * create Inventory_report.txt.
	 * 
	 * @param inven
	 *            a list of Inventory.
	 * @throws ApplicationException
	 * @throws FileNotFoundException
	 */
	public static void createInventoryReport(List<Inventory> inven) throws ApplicationException {

		if (BcmcOption.isFilterOption()) {
			inven = Filter.filterInventory(inven);
		}
		if (BcmcOption.IsDescriptionOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByDescriptionDescending());
			} else {
				Collections.sort(inven, new CompareByDescription());
			}
		}
		if (BcmcOption.IsCountOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByCountDescending());
			} else {
				Collections.sort(inven, new CompareByCount());
			}
		}

		try {
			PrintWriter outputfile = new PrintWriter(FILEOUT);
			outputfile.format("Inventory Report%n");
			outputfile.format(HORIZONTAL_LINE + "%n");
			outputfile.format(HEADER_FORMAT, "Make+Model", "Description", "Part#", "Price", "Quantity");
			outputfile.format(HORIZONTAL_LINE + "%n");

			for (Inventory inventory : inven) {
				outputfile.format(INVENTORY_FORMAT, inventory.getId(), inventory.getDescription(), inventory.getPartNumber(), inventory.getPrice(),
						inventory.getQuantity());
			}
			outputfile.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("Error creating %s", FILEOUT));
		}
		LOG.info(FILEOUT + " created");
	}

	/**
	 * create Inventory_report.txt. with Total
	 * 
	 * @param inven
	 *            a list of Inventory.
	 * @throws ApplicationException
	 * @throws FileNotFoundException
	 */
	public static void createInventoryReportTotal(List<Inventory> inven) throws ApplicationException {

		if (BcmcOption.isFilterOption()) {
			inven = Filter.filterInventory(inven);
		}
		if (BcmcOption.IsDescriptionOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByDescriptionDescending());
			} else {
				Collections.sort(inven, new CompareByDescription());
			}
		}
		if (BcmcOption.IsCountOption()) {
			if (BcmcOption.isDescendingOption()) {
				Collections.sort(inven, new CompareByCountDescending());
			} else {
				Collections.sort(inven, new CompareByCount());
			}
		}

		double total = 0;
		try {
			PrintWriter outputfile = new PrintWriter(FILEOUT);
			outputfile.format("Inventory Report%n");
			outputfile.format(HORIZONTAL_LINE + "-----------%n");
			outputfile.format(HEADERTOTAL_FORMAT, "Make+Model", "Description", "Part#", "Price", "Quantity", "Value");
			outputfile.format(HORIZONTAL_LINE + "-----------%n");

			for (Inventory inventory : inven) {
				double totalTemp = inventory.getQuantity() * inventory.getPrice();
				outputfile.format(INVENTORYTOTAL_FORMAT, inventory.getId(), inventory.getDescription(), inventory.getPartNumber(),
						inventory.getPrice(), inventory.getQuantity(), totalTemp);
				total = total + totalTemp;
			}
			outputfile.format("Value of current inventory: $%,.2f%n", total);
			outputfile.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("Error creating %s", FILEOUT));
		}
		LOG.info(FILEOUT + " with total created");
	}
}