// Order.java
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items = new ArrayList<>();
    private double totalPrice;

    public void addItem(FoodItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void displayOrder() {
        System.out.println("\nYour Order:");
        for (FoodItem item : items) {
            System.out.println(item.getName() + " - $" + String.format("%.2f", item.getPrice()));
        }
        System.out.println("\nTotal: $" + String.format("%.2f", totalPrice));
    }

    public void generateBill() {
        System.out.println("\n----- BILL -----");
        for (FoodItem item : items) {
            System.out.println(item.getName() + " - Rs." + String.format("%.2f", item.getPrice()));
        }
        System.out.println("---------------");
        System.out.println("Total Amount: Rs." + String.format("%.2f", totalPrice));
        System.out.println("Thank you for your order!");
    }
}
