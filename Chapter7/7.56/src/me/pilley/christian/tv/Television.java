/**
 * 
 */
package me.pilley.christian.tv;

/**
 * @author Christian Pilley
 *
 */
public class Television {
	private int price;
	private String brand;
	/**
	 * Default constructor to make a new Television Object
	 */
	public Television() {
	}
	/**Overloaded Constructor to make a Television Object with set parameters
	 * 
	 * @param brand - Sets the brand of the TV
	 * @param price - Sets the price of the TV
	 */
	public Television(String brand,int price) {
		this.price = price;
		this.brand = brand;
	}
	/** Gets the price of the Television object
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/** Sets the price of the Television object
	 * 
	 * @param price - Value for the price variable
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**Gets the brand of the Television object
	 * 
	 * @return brand 
	 */
	public String getBrand() {
		return brand;
	}
	/**Sets the brand of the Television object
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * Overridden toString() method to show the brand and the price
	 */
	@Override
	public String toString() {
		return brand + ": $" + price;
	}
	
	/**
	 * Overridden equals method that takes an object to test equality
	 * 
	 * @param obj - Object that is being tested for equality
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Television) {
			Television temp = (Television) obj;
			if (temp.brand == brand) {
				if (temp.price == price)
					return true;
			}
		}
		return false;
	}

}
