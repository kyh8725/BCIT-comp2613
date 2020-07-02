/**
 * Project: Lab08
 * File: Runners.java
 * Date: Jun 3, 2017
 * Time: 1:48:15 AM
 */

package a00904649.data;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Runners extends Thread {

	private int bibNumber;
	private String country;
	private String lastName;
	private String firstName;
	private double reactionTime;
	private int laneNumber;
	private double result;

	/**
	 * @param bibNumber
	 * @param country
	 * @param lastName
	 * @param firstName
	 * @param reactionTime
	 * @param laneNumber
	 */
	public Runners(int bibNumber, String country, String lastName, String firstName, double reactionTime, int laneNumber) {
		setBibNumber(bibNumber);
		setCountry(country);
		setLastName(lastName);
		setFirstName(firstName);
		setReactionTime(reactionTime);
		setLaneNumber(laneNumber);
	}

	/**
	 * @return the bibNumber
	 */
	public int getBibNumber() {
		return bibNumber;
	}

	/**
	 * @param bibNumber
	 *            the bibNumber to set
	 */
	public void setBibNumber(int bibNumber) {
		this.bibNumber = bibNumber;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the reactionTime
	 */
	public double getReactionTime() {
		return reactionTime;
	}

	/**
	 * @param reactionTime
	 *            the reactionTime to set
	 */
	public void setReactionTime(double reactionTime) {
		this.reactionTime = reactionTime;
	}

	/**
	 * @return the laneNumber
	 */
	public int getLaneNumber() {
		return laneNumber;
	}

	/**
	 * @param laneNumber
	 *            the laneNumber to set
	 */
	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public void run() {
		Instant startTime = Instant.now();
		int i = 0;
		long delay = 90L + ThreadLocalRandom.current().nextInt(22);
		while (i++ < 100) {
			try {
				Thread.sleep((long) (delay + reactionTime));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		Instant endTime = Instant.now();
		result = Duration.between(startTime, endTime).toMillis() / 1000.0;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Runners [bibNumber=" + bibNumber + ", country=" + country + ", lastName=" + lastName + ", firstName=" + firstName + ", reactionTime="
				+ reactionTime + ", laneNumber=" + laneNumber + ", result=" + result + "]";
	}

}
