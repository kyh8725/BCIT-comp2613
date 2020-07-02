/**
 * Project: Assignment1
 * File: CompareByJoinedDate.java
 * Date: May 6, 2017
 * Time: 12:42:55 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Customer;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByJoinedDate implements Comparator<Customer> {

	@Override
	public int compare(Customer customer1, Customer customer2) {
		return customer1.getJoinedDate().compareTo(customer2.getJoinedDate());
	}
}
