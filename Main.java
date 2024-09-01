// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        Order order = new Order();

        while (true) {
            System.out.println("\n1. Display Menu");
            System.out.println("2. Add Food Item to Menu");
            System.out.println("3. Remove Food Item from Menu");
            System.out.println("4. Update Food Item Price");
            System.out.println("5. Place an Order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuService.displayMenu();
                    break;
                case 2:
                    System.out.print("Enter food name: ");
                    scanner.nextLine();  // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    menuService.addFoodItem(name, price);
                    break;
                case 3:
                    menuService.displayMenu();
                    System.out.print("Enter the item number to remove: ");
                    int removeIndex = scanner.nextInt();
                    menuService.removeFoodItem(removeIndex - 1);
                    break;
                case 4:
                    menuService.displayMenu();
                    System.out.print("Enter the item number to update: ");
                    int updateIndex = scanner.nextInt();
                    System.out.print("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    menuService.updateFoodItemPrice(updateIndex - 1, newPrice);
                    break;
                case 5:
                    while (true) {
                        menuService.displayMenu();
                        System.out.println("Enter the number of the item to add to your order (0 to checkout): ");
                        int orderChoice = scanner.nextInt();

                        if (orderChoice == 0) {
                            break;
                        }

                        FoodItem item = menuService.getFoodItem(orderChoice - 1);
                        if (item != null) {
                            order.addItem(item);
                            System.out.println(item.getName() + " added to your order.");
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }

                    // Display the order summary
                    order.displayOrder();

                    // Generate and display the bill
                    order.generateBill();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
