
/** 
 * Author : ShouTzu, Han 
 * Class : CS232 Programming with Java 
 * Project : Assignment #3 Shopping list  
 * Finished date : 25-Oct-2021 
 * Due date : 26-Oct-2021 
 */

                                                                                                                

public class ShoppingList {

	private Item items[];
	private int numItems = 0;
	private int cartCapacity = 0;

	/*
	 * Create shopping list with the number of items
	 */
	public ShoppingList(int numItems) {
		this.numItems = numItems;
		items = new Item[numItems];
	}

	/*
	 * Add an Item object in the shopping list
	 */
	public void addItem(Item item) {
		// Check cart capacity
		if (cartCapacity + 1 > numItems) {
			System.out.println("Shopping list is full.");
			return;
		}

		items[cartCapacity++] = item;
	}

	/*
	 * Add an item data in the shopping list
	 */
	public void addItem(String name, int quantity, double price, int priority) {
		Item item = new Item(name, quantity, price, priority);
		/** 直接使用addItem(Item)即可 **/
		addItem(item);
	}

	/*
	 * Get an item by name
	 */
	public Item getItem(String name) {
		for (int i = 0; i < cartCapacity; i++) {
			if (items[i].getName().equals(name)) {
				return items[i];
			}
		}
		return null;
	}

	/*
	 * Check if an item is already in the shopping list
	 */
    public boolean checkItem(String name) {
    	for (int i = 0; i < cartCapacity; i++) {
			if (items[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
    }

	/*
	 * Count the total price of the shopping list
	 */
	public double totalPrice() {
		double total = 0;
		for (int i = 0; i < cartCapacity; i++) {
			total = total + items[i].getPrice() * items[i].getQuantity();
		}
		return total;
	}

	/*
	 * Bubble sort by the priority of items
	 */
	private void bubbleSort() {
		for (int i = 0; i < cartCapacity - 1; i++)
			for (int j = 0; j < cartCapacity - i - 1; j++)

				if (items[j].compareTo(items[j + 1]) > 0) {
					// CompareTo method: a.compareTo(b) -> a > b return 1,
					//                                     a < b return -1,
					//                                     a = b return 0
					Item temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
	}

	/*
	 * Get formatted data of the shopping list
	 */
	public String toString() {

		// Sort by priority
		bubbleSort();

		String cart = String.format("    %8s\t%5s\t%5s\t%5s\t%5s\n", "Priority", "Name", "Price", "Qty", "Total");
		for (int i = 0; i < cartCapacity; i++) {
			cart += "    " + items[i] + "\n";
		}
		cart += String.format("\n%45s : %.2f\n", "TOTAL", totalPrice());

		return cart;
	}

	/*
	 * Remove items from the shopping list
	 */
	private void removeItems(Item[] purchasedItems, int count) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < cartCapacity; j++) {
				if (items[j].getName().equals(purchasedItems[i].getName())) {
					items[j] = items[--cartCapacity];
				}
			}
		}
	}

	/*
	 * Purchase and print the result
	 */
	public void purchase(double budget) {

		// Purchased items
		Item purchasedItems[] = new Item[cartCapacity];
		int count = 0;
		double total = 0;
		System.out.println("    Items was purchased :");
		System.out.println();
		System.out.println("    " + String.format("%8s\t%5s\t%5s\t%5s\t%5s\n", "Priority", "Name", "Price", "Qty", "Total"));
		for (int i = 0; i < cartCapacity; i++) {
			if (total + items[i].getTotalPrice() > budget) {
				continue;
			}
			System.out.println("    " + items[i]);
			total += items[i].getTotalPrice();
			purchasedItems[count++] = items[i];
		}
		System.out.println();
		System.out.println(String.format("%45s: %.2f", "TOTAL", total));

		// Not purchased items
		removeItems(purchasedItems, count);
		System.out.println();
		System.out.println("    Items was not purchased :");
		System.out.println();
		System.out.println(toString());
	}
}
