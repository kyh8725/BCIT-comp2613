/**
 * Project: Assignment1
 * File: BcmcOption.java
 * Date: May 14, 2017
 * Time: 2:33:24 PM
 */

package a00904649;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class BcmcOption {

	private static CommandLine cmd;
	private static boolean ARG;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * private constructor to prevent instantiation
	 */
	private BcmcOption() {
	}

	public static void process(String[] args) throws ApplicationException {
		try {
			CommandLineParser cli = new DefaultParser();
			if (args.length == 0) {
				ARG = true;
			}
			cmd = cli.parse(createOptions(), args);
		} catch (ParseException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/**
	 * create and add all the options for Bcmc
	 * 
	 * @return options
	 */
	public static Options createOptions() {

		Options options = new Options();
		options.addOption("s", "service", false, "Print out service report");
		options.addOption("i", "inventory", false, "Print out inventory report");
		options.addOption("c", "customers", false, "Print out customer report");
		options.addOption("t", "total", false, "Print out inventory report with values and total");
		options.addOption("D", "by_description", false, "Sort the inventory by part description name ascending and print out report");
		options.addOption("C", "by_count", false, "Sort the inventory by part count ascending and print out report");
		options.addOption("J", "by_join_date", false, "Sort the customer by join date and print out report");
		options.addOption("m", "make", true, "Filters the service or inventory report by make ascending");
		options.addOption("d", "desc", false, "Any sorted value is sorted in a descending order");
		options.addOption("?", "help", false, "list of option and description");
		LOG.debug("Bcmc Options created");
		return options;
	}

	public static boolean isServiceOption() {
		boolean isService = false;
		if (ARG || cmd.hasOption("s")) {
			isService = true;
		} else {
			isService = false;
		}

		return isService;
	}

	public static boolean isInventoryOption() {
		boolean isInventory = false;
		if (ARG || cmd.hasOption("i")) {
			isInventory = true;
		} else {
			isInventory = false;
		}
		return isInventory;
	}

	public static boolean isCustomersOption() {
		boolean isCustomer;
		if (ARG || cmd.hasOption("c")) {
			isCustomer = true;
		} else {
			isCustomer = false;
		}
		return isCustomer;
	}

	public static boolean IsJoinDateOption() {
		boolean joinDate;
		if (cmd.hasOption("J")) {
			joinDate = true;
		} else {
			joinDate = false;
		}
		return joinDate;
	}

	public static boolean IsTotalOption() {
		boolean total;
		if (cmd.hasOption("t")) {
			total = true;
		} else {
			total = false;
		}
		return total;
	}

	public static boolean IsCountOption() {
		boolean count;
		if (cmd.hasOption("C")) {
			count = true;
		} else {
			count = false;
		}
		return count;
	}

	public static boolean IsDescriptionOption() {
		boolean description;
		if (cmd.hasOption("D")) {
			description = true;
		} else {
			description = false;
		}
		return description;
	}

	public static boolean isDescendingOption() {
		boolean descending;
		if (cmd.hasOption("d")) {
			descending = true;
		} else {
			descending = false;
		}
		return descending;
	}

	public static boolean isFilterOption() {
		boolean filter;
		if (cmd.hasOption("m")) {
			filter = true;
		} else {
			filter = false;
		}
		return filter;
	}

	/**
	 * display option help
	 */
	public static void optionHelp() {
		if (cmd.hasOption("?")) {
			Options options = createOptions();
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Bcmc option help", options);
		}
	}

}
