/**
 * Project: Assignment2
 * File: UIController.java
 * Date: Jul 1, 2017
 * Time: 1:30:14 AM
 */

package a00904649.ui;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;
import a00904649.data.Inventory;
import a00904649.data.util.CompareByCount;
import a00904649.data.util.CompareByDescription;
import a00904649.data.util.InventoryFilter;
import a00904649.database.dao.InventoryDao;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class UIController {

	private static final Logger LOG = LogManager.getLogger();

	private static JFrame mainFrame;

	@SuppressWarnings("static-access")
	public UIController(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	protected static class AboutMenuItemHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(mainFrame, "BCMC Assignment 2\nBy Daniel Kim A00904649", "About Assignment 2",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected static class QuitMenuItemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Instant endTime = Instant.now();
			LOG.info("End: " + endTime);
			LOG.info(String.format("Duration: %d ms", Duration.between(Bcmc.startTime, endTime).toMillis()));
			System.exit(0);
		}
	}

	protected static class CustomerMenuItemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(mainFrame, "This feature is not available yet", "Customers", JOptionPane.INFORMATION_MESSAGE);
			LOG.info("Customers menu list clicked and info message displayed");
		}
	}

	protected static class ServiceMenuItemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(mainFrame, "This feature is not available yet", "Service", JOptionPane.INFORMATION_MESSAGE);
			LOG.info("Service menu list clicked and info message displayed");
		}
	}

	protected static class InventoryMenuItemHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				InventoryListDialog dialog = new InventoryListDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				LOG.debug("InventoryListDialog created");
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	}

	protected static class InventoryItemsSelectionHandler implements ListSelectionListener {
		private JList<Inventory> itemsList;
		private InventoryListModel inventoryListModel;

		public InventoryItemsSelectionHandler(JList<Inventory> itemsList) {
			this.itemsList = itemsList;
			inventoryListModel = (InventoryListModel) itemsList.getModel();
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting()) {
				return;
			}

			Inventory item = itemsList.getSelectedValue();
			if (item != null) {
				LOG.debug("Item selected: " + itemsList.getSelectedIndex());
				updateItem(item, itemsList.getSelectedIndex());
			}
		}

		private void updateItem(Inventory item, int index) {
			try {
				InventoryDao invDao = InventoryDao.getInstance();
				InventoryDialog dialog = new InventoryDialog(item);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);
				LOG.debug("Updating item: " + item.getPartNumber());
				item = dialog.getItem();
				invDao.update(item);
				inventoryListModel.update(index, item);
				LOG.debug("Item " + item.getPartNumber() + " updated");
			} catch (Exception exception) {
				LOG.error(exception.getMessage());
			}
			itemsList.clearSelection();
		}
	}

	protected static class TotalMenuItemHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LOG.info("Total menu clikced and message displayed");
			double total = 0;
			try {
				InventoryDao invDao = InventoryDao.getInstance();
				List<Inventory> itemsList = invDao.getInventoryList();
				for (Inventory i : itemsList) {
					total += i.getPrice() * Double.valueOf(i.getQuantity());
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				LOG.error(exception.getMessage());
			}
			JOptionPane.showMessageDialog(mainFrame, String.format("The total amount of the Inventory is $%.2f", total), "Inventory Total",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected static class byCountMenuItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LOG.info("By count menu item pressed.");
			try {
				InventoryDao invDao = InventoryDao.getInstance();
				List<Inventory> itemsList = invDao.getInventoryList();
				Collections.sort(itemsList, new CompareByCount());
				LOG.info("Inventory data sorted by Count");
				InventoryReportDialog dialog = new InventoryReportDialog(itemsList, "By Count");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception exception) {

			}
		}
	}

	protected static class byDescriptionMenuItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LOG.info("By description menu item pressed.");

			try {
				InventoryDao invDao = InventoryDao.getInstance();
				List<Inventory> itemsList = invDao.getInventoryList();
				Collections.sort(itemsList, new CompareByDescription());
				LOG.info("Inventory data sorted by Description");
				InventoryReportDialog dialog = new InventoryReportDialog(itemsList, "By Description");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception exception) {
				LOG.error(exception.getMessage());
			}
		}
	}

	protected static class makeMenuItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LOG.info("Make menu item pressed.");
			List<Inventory> itemsList = new ArrayList<>();
			String make = JOptionPane.showInputDialog("Enter make value: \n");
			if (make == null) {
				return;
			}
			try {
				InventoryDao invDao = InventoryDao.getInstance();
				itemsList = invDao.getInventoryList();
				if (make.equalsIgnoreCase("honda")) {
					LOG.info("no items matching with provided make name. all inventory item list displayed");
					itemsList = InventoryFilter.filterInventory(itemsList);
					LOG.info("Inventory data filtered. only HONDA's product displayed");
				} else {
					itemsList = invDao.getInventoryList();
				}

				InventoryReportDialog dialog = new InventoryReportDialog(itemsList, "By Make");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (

			Exception exception) {
				LOG.error(exception.getMessage());
			}
		}
	}
}
