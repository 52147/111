
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

		/** 用變數記錄題目中的數字，以便修改 **/
		int numItems = 7;
		int budget = 59;
		int minTotal = 100;

		ShoppingList list = new ShoppingList(numItems);
		/** Scanner可以重複使用，宣告一個實體可以省記憶體 **/
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= numItems; i++) {
			System.out.println("Item #" + i);

			/** 題目沒有ID，可以用unique name來比對Item，可取代ID的作用，所以刪掉ID **/

			System.out.print("Enter item name : ");
			String name = scanner.next();

			/** 檢查name有沒有重複 **/
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

		/** 檢查total price符不符合題目限制 **/
		// Check the total price of the items in the shopping list
		if (list.totalPrice() < minTotal) {
			System.out.println("[Warning] Total price of the items = $" + list.totalPrice() + " is less than $" + minTotal + ".");
			return;
		}

		// Use the budget to purchase items in the shopping list
		list.purchase(budget);
	}
}
