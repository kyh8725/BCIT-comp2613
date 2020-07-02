/**
 * Project: Lab07
 * File: Lab7Option.java
 * Date: May 28, 2017
 * Time: 3:39:20 AM
 */

package a00904649;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab7Option {

	private static boolean isTable = false;
	private static CommandLine cmd;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * private constructor to prevent instantiation
	 */
	private Lab7Option() {
	}

	public static void process(String[] args) throws ApplicationException {
		try {
			CommandLineParser cli = new DefaultParser();
			cmd = cli.parse(createOptions(), args);
		} catch (ParseException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/**
	 * create and add all the options for Lab7
	 * 
	 * @return options
	 */
	public static Options createOptions() {

		Options options = new Options();
		options.addOption("d", "drop", false, "drop the table");
		LOG.debug("Lab7 Options created");
		return options;
	}

	public static boolean isTableExist() {
		if (cmd.hasOption("d")) {
			isTable = true;
		} else {
			isTable = false;
		}
		return isTable;
	}

}
