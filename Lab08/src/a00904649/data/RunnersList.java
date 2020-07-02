/**
 * Project: Lab08
 * File: RunnersList.java
 * Date: Jun 3, 2017
 * Time: 10:29:43 AM
 */

package a00904649.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class RunnersList {

	private List<Runners> runnersList;

	/**
	 * RunnersList constructor
	 * 8 runners loaded
	 */
	public RunnersList() {
		loadRunners();
	}

	/**
	 * loads 8 runners to the ArrayList
	 */
	private void loadRunners() {
		runnersList = new ArrayList<>();
		runnersList.add(new Runners(4, "USA", "GATLIN", "Justin", 0.152, 3069));
		runnersList.add(new Runners(6, "JAM", "BOLT", "Usain", 0.155, 2612));
		runnersList.add(new Runners(3, "RSA", "SIMBINE", "Akani", 0.128, 2909));
		runnersList.add(new Runners(7, "CAN", "DE GRASSE", "Andre", 0.141, 2196));
		runnersList.add(new Runners(9, "JAM", "BLAKE", "Yohan", 0.145, 2611));
		runnersList.add(new Runners(2, "USA", "BROMELL", "Trayvon", 0.135, 3054));
		runnersList.add(new Runners(8, "CIV", "MEITE", "Ben Youssef", 0.156, 2245));
		runnersList.add(new Runners(5, "FRA", "VICAUT", "Jimmy", 0.140, 2234));
	}

	/**
	 * returns the list of Runners objects
	 * 
	 * @return runnersList list of Runners objects
	 */
	public List<Runners> getRunnersList() {
		return runnersList;
	}

}
