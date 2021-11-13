
/** 
 * Author : ShouTzu, Han 
 * Class : CS232 Programming with Java 
 * Project : Assignment #3 Shopping list  
 * Finished date : 25-Oct-2021 
 * Due date : 26-Oct-2021 
 */



public class Item implements Comparable<Item> {

	private String name;
	private double price;
	private int quantity;
	private int priority;

	public Item(String name, int quantity, double price, int priority) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.priority = priority;
	}

	public String toString() {
		return String.format("%8d\t%5s\t%5.2f\t%5d\t%5.2f", priority, name, price, quantity, getTotalPrice());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return price * quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int compareTo(Item item) {
		if (getPriority() > item.getPriority()) {
			return 1;
		} else if (getPriority() < item.getPriority()) {
			return -1;
		} else {
			return 0;
		}
	}
}
