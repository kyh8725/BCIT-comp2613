/**
 * Project: Assignment2
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

	private String motorcycleId;
	private String description;
	private String partNumber;
	private double price;
	private String quantity;

	public String getMotorcycleId() {
		return motorcycleId;
	}

	public void setMotorcycleId(String motorcycleId) {
		this.motorcycleId = motorcycleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Inventory getInventory() {
		return this;
	}

	public static class Builder {

		private String motorcycleId;
		private String description;
		private String partNumber;
		private double price;
		private String quantity;

		public Builder(String motorcycleId) {
			this.motorcycleId = motorcycleId;
		}

		public Builder description(String val) {
			description = val;
			return this;
		}

		public Builder partNumber(String val) {
			partNumber = val;
			return this;
		}

		public Builder price(double val) {
			price = val;
			return this;
		}

		public Builder quantity(String val) {
			quantity = val;
			return this;
		}

		public Inventory build() {
			return new Inventory(this);
		}
	}

	private Inventory(Builder builder) {
		motorcycleId = builder.motorcycleId;
		description = builder.description;
		partNumber = builder.partNumber;
		price = builder.price;
		quantity = builder.quantity;
	}

	/**
	 * Inventory Constructor
	 * 
	 * @param id
	 * @param description
	 * @param partNumber
	 * @param price
	 * @param quantity
	 */
	public Inventory(String id, String description, String partNumber, double price, String quantity) {
		setMotorcycleId(id);
		setDescription(description);
		setPartNumber(partNumber);
		setPrice(price);
		setQuantity(quantity);
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", motorcycleId, description, partNumber, price, quantity);
	}

}
