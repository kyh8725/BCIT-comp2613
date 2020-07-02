/**
 * Project: Assignment2
 * File: MainFrame.java
 * Date: Jun 30, 2017
 * Time: 10:20:49 PM
 */

package a00904649.ui;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;

	private JMenuItem mntmAbout;
	private JMenuItem mntmInventory;
	private JMenuItem mntmQuit;
	private JMenuItem mntmCustomers;
	private JMenuItem mntmService;
	private JMenuItem mntmTotal;
	private JMenuItem mntmByCount;
	private JMenuItem mntmByDescription;
	private JMenuItem mntmMake;

	public MainFrame() {
		createUI();
		addEventHandlers();
	}

	/**
	 * Create the frame.
	 */
	private void createUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK));
		mnFile.add(mntmQuit);

		JMenu mnData = new JMenu("Data");
		menuBar.add(mnData);

		mntmCustomers = new JMenuItem("Customers");
		mntmCustomers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.ALT_MASK));
		mnData.add(mntmCustomers);

		mntmService = new JMenuItem("Service");
		mntmService.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.ALT_MASK));
		mnData.add(mntmService);

		mntmInventory = new JMenuItem("Inventory");
		mntmInventory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.ALT_MASK));
		mnData.add(mntmInventory);

		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);

		mntmTotal = new JMenuItem("Total");
		mntmTotal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.ALT_MASK));
		mnReports.add(mntmTotal);

		mntmByDescription = new JMenuItem("By Description");
		mntmByDescription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.ALT_MASK));
		mnReports.add(mntmByDescription);

		mntmByCount = new JMenuItem("By Count");
		mntmByCount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.ALT_MASK));
		mnReports.add(mntmByCount);

		mntmMake = new JMenuItem("Make");
		mntmMake.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.ALT_MASK));
		mnReports.add(mntmMake);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private void addEventHandlers() {
		new UIController(this);
		mntmQuit.addActionListener(new UIController.QuitMenuItemHandler());
		mntmAbout.addActionListener(new UIController.AboutMenuItemHandler());
		mntmCustomers.addActionListener(new UIController.CustomerMenuItemHandler());
		mntmService.addActionListener(new UIController.ServiceMenuItemHandler());
		mntmInventory.addActionListener(new UIController.InventoryMenuItemHandler());
		mntmTotal.addActionListener(new UIController.TotalMenuItemHandler());
		mntmByCount.addActionListener(new UIController.byCountMenuItem());
		mntmByDescription.addActionListener(new UIController.byDescriptionMenuItem());
		mntmMake.addActionListener(new UIController.makeMenuItem());
	}
}
