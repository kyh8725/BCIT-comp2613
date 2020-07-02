/**
 * Project: Lab05
 * File: CompareByJoinedDate.java
 * Date: May 3, 2017
 * Time: 9:40:39 PM
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
