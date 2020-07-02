/**
 * Project: Assignment2
 * File: InventoryListDialog.java
 * Date: Jun 30, 2017
 * Time: 10:45:55 PM
 */

package a00904649.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;
import a00904649.data.Inventory;
import a00904649.database.dao.InventoryDao;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class InventoryListDialog extends JDialog {

	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private final JPanel contentPanel = new JPanel();
	private JList<Inventory> inventoryList;
	private InventoryListModel inventoryModel;

	public InventoryListDialog() throws FileNotFoundException, IOException {
		createUI();
		setData();
		addEventHandlers();
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws SQLException
	 */
	private void createUI() {
		LOG.info("InventoryListDialog created");
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						InventoryListDialog.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		inventoryModel = new InventoryListModel();
		inventoryList = new JList<>(inventoryModel);
		inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(inventoryList));

	}

	public void setData() throws FileNotFoundException, IOException {
		try {
			InventoryDao inventoryDao = InventoryDao.getInstance();
			List<Inventory> inventories = inventoryDao.getInventoryList();
			for (Inventory inventory : inventories) {
				inventoryModel.add(inventory);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
	}

	private void addEventHandlers() {
		LOG.info("Event Handlers add for InventoryListDialog");
		inventoryList.getSelectionModel().addListSelectionListener(new UIController.InventoryItemsSelectionHandler(inventoryList));
	}
}
