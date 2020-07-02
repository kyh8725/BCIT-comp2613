/**
 * Project: Lab08
 * File: Report.java
 * Date: Jun 3, 2017
 * Time: 9:17:39 AM
 */

package a00904649.io;

import java.util.List;

import a00904649.data.Runners;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Report {

	public static final String BORDER = "====================================================================";
	public static final String HEADER_FORMAT = "%-4s %-4s %-4s %-10s %-11s %-12s %-10s %-10s %n";
	public static final String RUNNER_FORMAT = "%4s %4s %4s %7s %12s %12s %10.3f %8.3f %n";

	/**
	 * private constructor to prevent instantiation
	 */
	private Report() {
	}

	/**
	 * prints out the report of the result
	 * 
	 * @param runnersList
	 *            List of Runners objects
	 */
	public static void writeReport(List<Runners> runnersList) {
		System.out.println(BORDER);
		System.out.format(HEADER_FORMAT, "Rank", "Lane", "Bib#", "Country", "Last Name", "First Name", "Reaction", "Result");
		int i = 0;
		for (Runners runner : runnersList) {
			System.out.format(RUNNER_FORMAT, ++i, runner.getLaneNumber(), runner.getBibNumber(), runner.getCountry(), runner.getLastName(),
					runner.getFirstName(), runner.getReactionTime(), runner.getResult());
		}
		System.out.println(BORDER);
	}

}
