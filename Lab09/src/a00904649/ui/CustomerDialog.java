/**
 * Project: Lab09
 * File: CustomerDialog.java
 * Date: Jun 10, 2017
 * Time: 11:21:35 AM
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

import a00904649.data.Customer;
import net.miginfocom.swing.MigLayout;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class CustomerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDTextField;
	private JTextField FirstNameTextField;
	private JTextField LastNameTextField;
	private JTextField StreetTextField;
	private JTextField CityTextField;
	private JTextField PostalCodeTextField;
	private JTextField PhoneTextField;
	private JTextField EmailTextField;
	private JTextField JoinedDateTextField;

	/**
	 * Create the dialog.
	 */
	public CustomerDialog() {
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId, "cell 0 0,alignx trailing");
		}
		{
			IDTextField = new JTextField();
			IDTextField.setEnabled(false);
			IDTextField.setEditable(false);
			contentPanel.add(IDTextField, "cell 1 0,growx");
			IDTextField.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First Name");
			contentPanel.add(lblFirstName, "cell 0 1,alignx trailing");
		}
		{
			FirstNameTextField = new JTextField();
			contentPanel.add(FirstNameTextField, "cell 1 1,growx");
			FirstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			contentPanel.add(lblLastName, "cell 0 2,alignx trailing");
		}
		{
			LastNameTextField = new JTextField();
			contentPanel.add(LastNameTextField, "cell 1 2,growx");
			LastNameTextField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street");
			contentPanel.add(lblStreet, "cell 0 3,alignx trailing");
		}
		{
			StreetTextField = new JTextField();
			contentPanel.add(StreetTextField, "cell 1 3,growx");
			StreetTextField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			contentPanel.add(lblCity, "cell 0 4,alignx trailing");
		}
		{
			CityTextField = new JTextField();
			contentPanel.add(CityTextField, "cell 1 4,growx");
			CityTextField.setColumns(10);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code");
			contentPanel.add(lblPostalCode, "cell 0 5,alignx trailing");
		}
		{
			PostalCodeTextField = new JTextField();
			contentPanel.add(PostalCodeTextField, "cell 1 5,growx");
			PostalCodeTextField.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone");
			contentPanel.add(lblPhone, "cell 0 6,alignx trailing");
		}
		{
			PhoneTextField = new JTextField();
			contentPanel.add(PhoneTextField, "cell 1 6,growx");
			PhoneTextField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			contentPanel.add(lblEmail, "cell 0 7,alignx trailing");
		}
		{
			EmailTextField = new JTextField();
			contentPanel.add(EmailTextField, "cell 1 7,growx");
			EmailTextField.setColumns(10);
		}
		{
			JLabel lblJoinedDate = new JLabel("Joined Date");
			contentPanel.add(lblJoinedDate, "cell 0 8,alignx trailing");
		}
		{
			JoinedDateTextField = new JTextField();
			contentPanel.add(JoinedDateTextField, "cell 1 8,growx");
			JoinedDateTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setCustomer(Customer customer) {
		IDTextField.setText(String.valueOf(customer.getId()));
		FirstNameTextField.setText(customer.getLastName());
		LastNameTextField.setText(customer.getFirstName());
		StreetTextField.setText(customer.getStreet());
		CityTextField.setText(customer.getCity());
		PostalCodeTextField.setText(customer.getPostalCode());
		PhoneTextField.setText(customer.getPhone());
		EmailTextField.setText(customer.getEmailAddress());
		JoinedDateTextField.setText(customer.getJoinedDateString());
	}

}
