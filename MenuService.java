// MenuService.java
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<FoodItem> menu = new ArrayList<>();

    public MenuService() {
        // Initialize with a default selection of food items
        menu.add(new FoodItem("Burger", 5.99));
        menu.add(new FoodItem("Pizza", 8.99));
        menu.add(new FoodItem("Salad", 4.99));
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public FoodItem getFoodItem(int index) {
        if (index < 0 || index >= menu.size()) {
            return null;
        }
        return menu.get(index);
    }

    public void addFoodItem(String name, double price) {
        menu.add(new FoodItem(name, price));
        System.out.println(name + " added to the menu.");
    }

    public void removeFoodItem(int index) {
        if (index < 0 || index >= menu.size()) {
            System.out.println("Invalid index. Item not found.");
        } else {
            System.out.println(menu.get(index).getName() + " removed from the menu.");
            menu.remove(index);
        }
    }

    public void updateFoodItemPrice(int index, double newPrice) {
        if (index < 0 || index >= menu.size()) {
            System.out.println("Invalid index. Item not found.");
        } else {
            FoodItem item = menu.get(index);
            item.setPrice(newPrice);
            System.out.println(item.getName() + " price updated to $" + newPrice);
        }
    }
}
