/**
 * Project: Assignment1
 * File: CompareByJoinedDateDescending.java
 * Date: May 18, 2017
 * Time: 9:29:54 PM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Customer;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByJoinedDateDescending implements Comparator<Customer> {

	@Override
	public int compare(Customer customer1, Customer customer2) {
		return customer2.getJoinedDate().compareTo(customer1.getJoinedDate());
	}
}
