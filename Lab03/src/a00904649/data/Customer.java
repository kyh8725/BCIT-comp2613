/**
 * Project: Lab03
 * File: Customer.java
 * Date: Apr 22, 2017
 * Time: 4:04:37 PM
 */

package a00904649.data;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Customer {

	private int customerID;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String postalCode;
	private String phone;
	private String email;
	private String joinDate;

	public static class Builder {

		// required parameters
		private final int customerID;
		private final String phone;

		// optional parameters
		private String firstName;
		private String lastName;
		private String street;
		private String city;
		private String postalCode;
		private String email;
		private String joinDate;

		public Builder(int customerID, String phone) {
			this.customerID = customerID;
			this.phone = phone;
		}

		/**
		 * @param firstName
		 *            the firstName to set
		 * @return the Customer Builder
		 */
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		/**
		 * @param lastName
		 *            the lastName to set
		 * @return the Customer Builder
		 */
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		/**
		 * @param street
		 *            the street to set
		 * @return the Customer Builder
		 */
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		/**
		 * @param city
		 *            the city to set
		 * @return the Customer Builder
		 */
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}

		/**
		 * @param postalCode
		 *            the postalCode to set
		 * @return the Customer Builder
		 */
		public Builder setPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		/**
		 * @param email
		 *            the emailAddress to set
		 * @return the Customer Builder
		 */
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * @param joinDate
		 * @return the Customer Builder
		 */
		public Builder setJoinDate(String joinDate) {
			this.joinDate = joinDate;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}

	}

	/**
	 * default Customer constructor
	 * 
	 * @param builder
	 */
	private Customer(Builder builder) {
		customerID = builder.customerID;
		firstName = builder.firstName;
		lastName = builder.lastName;
		street = builder.street;
		city = builder.city;
		postalCode = builder.postalCode;
		phone = builder.phone;
		email = builder.email;
		joinDate = builder.joinDate;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [CustomerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", email=" + email + "]";
	}

}
