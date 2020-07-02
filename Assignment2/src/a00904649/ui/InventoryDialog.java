/**
 * Project: Assignment2
 * File: InventoryDialog.java
 * Date: Jun 30, 2017
 * Time: 10:40:15 PM
 */

package a00904649.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.data.Inventory;
import net.miginfocom.swing.MigLayout;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class InventoryDialog extends JDialog {

	private static final Logger LOG = LogManager.getLogger();

	private final JPanel contentPanel = new JPanel();
	private JTextField MotorcycleIdTextField;
	private JTextField DescriptionTextField;
	private JTextField PartNumberTextField;
	private JTextField PriceTextField;
	private JTextField QuantityTextField;

	private Inventory item;

	public InventoryDialog(Inventory item) {
		this.item = item;
		createUI();
		setItem();
	}

	/**
	 * Create the dialog.
	 */
	private void createUI() {
		LOG.info("Inventory Dialog created");
		setBounds(100, 100, 460, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		{
			JLabel lblMotorcycleId = new JLabel("Motorcycle ID");
			contentPanel.add(lblMotorcycleId, "cell 0 0,alignx trailing");
		}
		{
			MotorcycleIdTextField = new JTextField();
			MotorcycleIdTextField.setEditable(false);
			contentPanel.add(MotorcycleIdTextField, "cell 1 0,growx");
			MotorcycleIdTextField.setColumns(10);
		}
		{
			JLabel lblDescription = new JLabel("Description");
			contentPanel.add(lblDescription, "cell 0 1,alignx trailing");
		}
		{
			DescriptionTextField = new JTextField();
			contentPanel.add(DescriptionTextField, "cell 1 1,growx");
			DescriptionTextField.setColumns(10);
		}
		{
			JLabel lblPartNumber = new JLabel("Part Number");
			contentPanel.add(lblPartNumber, "cell 0 2,alignx trailing");
		}
		{
			PartNumberTextField = new JTextField();
			contentPanel.add(PartNumberTextField, "cell 1 2,growx");
			PartNumberTextField.setColumns(10);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			contentPanel.add(lblPrice, "cell 0 3,alignx trailing");
		}
		{
			PriceTextField = new JTextField();
			contentPanel.add(PriceTextField, "cell 1 3,growx");
			PriceTextField.setColumns(10);
		}
		{
			JLabel lblQuantity = new JLabel("Quantity");
			contentPanel.add(lblQuantity, "cell 0 4,alignx trailing");
		}
		{
			QuantityTextField = new JTextField();
			contentPanel.add(QuantityTextField, "cell 1 4,growx");
			QuantityTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						updateItem();
						InventoryDialog.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						InventoryDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void setItem() {
		LOG.debug("setting the InventoryDialog with Iventory item info");
		MotorcycleIdTextField.setText(item.getMotorcycleId());
		DescriptionTextField.setText(item.getDescription());
		PartNumberTextField.setText(item.getPartNumber());
		PriceTextField.setText(String.valueOf(item.getPrice()));
		QuantityTextField.setText(item.getQuantity());
	}

	private void updateItem() {
		LOG.debug("Inventory item info updated");
		item.setMotorcycleId(MotorcycleIdTextField.getText());
		item.setDescription(DescriptionTextField.getText());
		item.setPartNumber(PartNumberTextField.getText());
		item.setPrice(Double.parseDouble(PriceTextField.getText()));
		item.setQuantity(QuantityTextField.getText());
	}

	public Inventory getItem() {
		return item;
	}
}
