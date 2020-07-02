/**
 * Project: Assignment2
 * File: InventoryTableModel.java
 * Date: Jul 1, 2017
 * Time: 11:09:00 AM
 */

package a00904649.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;
import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class InventoryTableModel extends AbstractTableModel {
	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private static final String[] COLUMN_NAMES = { "Motorcycle ID", "Description", "Part Number", "Price", "Quantity" };

	private List<Inventory> invList;

	public InventoryTableModel() {
	}

	@Override
	public String getColumnName(int col) {
		return COLUMN_NAMES[col];
	}

	@Override
	public int getRowCount() {
		return invList.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return invList.get(rowIndex).getMotorcycleId();
		case 1:
			return invList.get(rowIndex).getDescription();
		case 2:
			return invList.get(rowIndex).getPartNumber();
		case 3:
			return invList.get(rowIndex).getPrice();
		case 4:
			return invList.get(rowIndex).getQuantity();
		default:
			return "";
		}
	}

	public void setInventoryItems(List<Inventory> inventoryItems) {
		LOG.debug("Setting the inventory items");
		this.invList = inventoryItems;
	}
}
