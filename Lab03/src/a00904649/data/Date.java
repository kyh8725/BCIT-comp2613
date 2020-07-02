/**
 * Project: Lab03
 * File: Date.java
 * Date: Apr 29, 2017
 * Time: 11:43:51 AM
 */

package a00904649.data;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Date {

	private int year;
	private int month;
	private int date;

	/**
	 * non-default Date constructor
	 * 
	 * @param year
	 * @param month
	 * @param date
	 */
	@Deprecated
	public Date(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}

	/**
	 * 
	 * @return the year
	 */
	@Deprecated
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @return the month
	 */
	@Deprecated
	public int getMonth() {
		return month;
	}

	/**
	 * 
	 * @return the date;
	 */
	@Deprecated
	public int getDate() {
		return date;
	};

}
