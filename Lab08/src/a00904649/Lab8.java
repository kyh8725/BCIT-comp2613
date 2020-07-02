/**
 * Project: Lab08
 * File: Lab8.java
 * Date: Jun 3, 2017
 * Time: 9:17:57 AM
 */

package a00904649;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import a00904649.data.Runners;
import a00904649.data.RunnersList;
import a00904649.data.util.CompareByResult;
import a00904649.io.Report;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab8 {

	private static final Instant startTime = Instant.now();

	/**
	 * multi-thread programming. Lab8
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println(startTime);
		start();
		printEndTimeAndDuration();
	}

	/**
	 * Loads 8 runners and simulates their run. Print the report sorted by result time;
	 * 
	 * @throws InterruptedException
	 */
	public static void start() throws InterruptedException {
		RunnersList list = new RunnersList();
		List<Runners> runners = list.getRunnersList();

		for (Runners runner : runners) {
			runner.start();
		}
		for (Runners runner : runners) {
			runner.join();
		}
		Collections.sort(runners, new CompareByResult());
		Report.writeReport(runners);
	}

	public static void printEndTimeAndDuration() {
		Instant endTime = Instant.now();
		System.out.println(endTime);
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}
}
