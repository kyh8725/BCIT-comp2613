/**
 * Project: Assignment2
 * File: InventoryReportDialog.java
 * Date: Jul 1, 2017
 * Time: 10:33:16 AM
 */

package a00904649.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;
import a00904649.data.Inventory;
import net.miginfocom.swing.MigLayout;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class InventoryReportDialog extends JDialog {
	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private List<Inventory> inventoryItems;
	private JLabel lblReportName;
	private String reportName;
	private JCheckBox chckbxDescending;
	private JTable table;
	private InventoryTableModel tableModel;

	/**
	 * Create the dialog.
	 */
	public InventoryReportDialog(List<Inventory> inventoryItems, String reportName) {
		this.inventoryItems = inventoryItems;
		this.reportName = reportName;
		createUI();
		addEventHandlers();
		setData();
	}

	public void setInventoryItems(List<Inventory> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	private void createUI() {
		LOG.info("Inventory report Dialog created");

		setBounds(100, 100, 574, 406);
		getContentPane().setLayout(new MigLayout("", "[455px][312px][320px]", "[][][][][][][][][][][][]"));
		{
			lblReportName = new JLabel("Report " + reportName + ": ");
			getContentPane().add(lblReportName, "cell 0 0,alignx right,aligny center");
		}
		{
			chckbxDescending = new JCheckBox("Descending");
			getContentPane().add(chckbxDescending, "cell 2 0,alignx left,aligny top");

		}

		tableModel = new InventoryTableModel();
		table = new JTable(tableModel);
		getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, "cell 0 1 3 10,grow");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 2 11,growx,aligny top");
			{
				JButton closeButton = new JButton("Close");
				closeButton.setActionCommand("Cancel");
				closeButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						InventoryReportDialog.this.dispose();
					}

				});
				buttonPane.add(closeButton);
			}
		}
	}

	private void addEventHandlers() {
		LOG.info("Eventhandlers for InventoryReportDialog added");
		chckbxDescending.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Collections.reverse(inventoryItems);
				tableModel = new InventoryTableModel();
				table.setModel(tableModel);
				setData();
			}

		});
	}

	private void setData() {
		LOG.info("data setted for InventoryReportDialog");
		tableModel.setInventoryItems(inventoryItems);
	}

}
