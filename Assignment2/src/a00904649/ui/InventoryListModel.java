/**
 * Project: Assignment2
 * File: InventoryListModel.java
 * Date: Jun 30, 2017
 * Time: 11:42:18 PM
 */

package a00904649.ui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;
import a00904649.data.Inventory;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class InventoryListModel extends AbstractListModel<Inventory> {

	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private ArrayList<Inventory> itemsList;

	public InventoryListModel() {
		itemsList = new ArrayList<>();
	}

	@Override
	public int getSize() {
		return itemsList == null ? 0 : itemsList.size();
	}

	@Override
	public Inventory getElementAt(int index) {
		return itemsList.get(index);
	}

	public void setInventoryItems(ArrayList<Inventory> itemsList) {
		this.itemsList = itemsList;

	}

	public ArrayList<Inventory> getInventoryItems() {
		return itemsList;
	}

	public void update(int index, Inventory item) {
		LOG.debug("InventoryListModel update item " + item.toString());
		itemsList.set(index, item);

		fireContentsChanged(this, index, index);
	}

	public void add(Inventory item) {
		LOG.debug("InventoryListModel add item " + item.toString());
		add(-1, item);
	}

	public void add(int index, Inventory item) {
		if (index == -1) {
			itemsList.add(item);
			index = getSize() - 1;
		} else {
			itemsList.add(index, item);
		}

		fireContentsChanged(this, index, index);
	}

}
