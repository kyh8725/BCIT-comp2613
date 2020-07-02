/**
 * Project: Assignment2
 * File: Bcmc.java
 * Date: Jun 28, 2017
 * Time: 8:06:32 PM
 */

package a00904649;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00904649.data.Inventory;
import a00904649.database.Database;
import a00904649.database.dao.InventoryDao;
import a00904649.io.InventoryReader;
import a00904649.ui.MainFrame;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Bcmc {
	public static Instant startTime;
	public static InventoryDao inventoryDao;
	private static Database database;
	public static final String LOG4J_CONFIG_FILENAME = "Log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	public static void main(String[] args) throws Exception {
		startTime = Instant.now();
		LOG.info("Start: " + startTime);
		loadInventory();
		createUI();
	}

	private static void createUI() {
		LOG.debug("Creating the UI MainFrame");
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LOG.debug("Setting the Look & Feel");
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		});
	}

	private static void loadInventory() throws ApplicationException, SQLException, FileNotFoundException, IOException {
		database = Database.getInstance();
		database.getConnection();
		inventoryDao = InventoryDao.getInstance();
		if (!Database.tableExists(InventoryDao.TABLE_NAME) || Database.dbTableDropRequested()) {
			if (Database.tableExists(InventoryDao.TABLE_NAME) && Database.dbTableDropRequested()) {
			}
			inventoryDao.create();
			LOG.debug("Inserting the inventory items");
			List<Inventory> inventories = InventoryReader.readInventoryFile();
			for (Inventory inventory : inventories) {
				inventoryDao.add(inventory);
			}
		}
	}

	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}
	}
}
