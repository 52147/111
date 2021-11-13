
/** 
 * Author : ShouTzu, Han 
 * Class : CS232 Programming with Java 
 * Project : Assignment #3 Shopping list  
 * Finished date : 25-Oct-2021 
 * Due date : 26-Oct-2021 
 */



import java.util.Scanner;

public class Driver {

	public static void main(String args[]) {

		int numItems = 7;
		int budget = 59;
		int minTotal = 100;

		ShoppingList list = new ShoppingList(numItems);
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= numItems; i++) {
			System.out.println("Item #" + i);


			System.out.print("Enter item name : ");
			String name = scanner.next();

			// Check if the item is already in the shopping list
			if (list.checkItem(name)) {
				System.out.println("[Warning] Item '" + name + "' is already in the shopping list.");
				System.out.println();
				System.out.println(list);
				return;
			}

			System.out.print("Enter Quantity : ");
			int quantity = scanner.nextInt();

			System.out.print("Enter the price of item : ");
			double price = scanner.nextDouble();

			System.out.print("Enter Priority Number : ");
			int priority = scanner.nextInt();

			// Create Item object
			Item item = new Item(name, quantity, price, priority);
			// Add the item in the shopping list
			list.addItem(item);

			System.out.println();
		}

		System.out.println();
		System.out.println("    Shopping list :");
		System.out.println();
		System.out.println(list); // Print the shopping list

		// Check the total price of the items in the shopping list
		if (list.totalPrice() < minTotal) {
			System.out.println("[Warning] Total price of the items = $" + list.totalPrice() + " is less than $" + minTotal + ".");
			return;
		}

		// Use the budget to purchase items in the shopping list
		list.purchase(budget);
	}
}
