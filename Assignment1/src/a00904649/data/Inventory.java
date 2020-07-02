/**
 * Project: Assignment1
 * File: Inventory.java
 * Date: May 4, 2017
 * Time: 8:13:46 PM
 */

package a00904649.data;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Inventory {

	public static final int ATTRIBUTE_COUNT = 5;
	public static final int INVENTORY_SIZE = 100;
	public static final int PRICE = 100;

	private String id;
	private String description;
	private String partNumber;
	private double price;
	private int quantity;

	/**
	 * Inventory Constructor
	 * 
	 * @param id
	 * @param description
	 * @param partNumber
	 * @param price
	 * @param quantity
	 */
	public Inventory(String id, String description, String partNumber, double price, int quantity) {
		setId(id);
		setDescription(description);
		setPartNumber(partNumber);
		setPrice(price);
		setQuantity(quantity);
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the partNumber
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * @param partNumber
	 *            the partNumber to set
	 */
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price / PRICE;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", description=" + description + ", partNumber=" + partNumber + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
