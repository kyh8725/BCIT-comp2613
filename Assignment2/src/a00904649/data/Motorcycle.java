/**
 * Project: Assignment2
 * File: Motorcycle.java
 * Date: May 4, 2017
 * Time: 8:07:16 PM
 */

package a00904649.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.Bcmc;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Motorcycle {
	public static final int MIN_YEAR = 1900;
	public static final int CURRENT_YEAR = 2017;
	public static final int ATTRIBUTE_COUNT = 7;
	public static final int MOTORCYCLES = 8;
	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private String id;
	private String make;
	private String model;
	private int year;
	private String serialNumber;
	private int mileage;
	private long customerID;

	/**
	 * @param id
	 * @param make
	 * @param model
	 * @param year
	 * @param serialNumber
	 * @param mileage
	 */
	public Motorcycle(String id, String make, String model, int year, String serialNumber, int mileage, long customerID) {
		setId(id);
		setMake(make);
		setModel(model);
		setYear(year);
		setSerialNumber(serialNumber);
		setMileage(mileage);
		setCustomerID(customerID);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		if (year > MIN_YEAR && year <= CURRENT_YEAR) {
			this.year = year;
		} else {
			LOG.error("Invalid year");
		}
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage
	 *            the mileage to set
	 */
	public void setMileage(int mileage) {
		if (mileage >= 0) {
			this.mileage = mileage;
		} else {
			LOG.error("Invalid mileage. can't be less than 0");
		}
	}

	/**
	 * @return the customerID
	 */
	public long getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Motorcycle [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", serialNumber=" + serialNumber + ", mileage="
				+ mileage + ", customerID=" + customerID + "]";
	}

}
