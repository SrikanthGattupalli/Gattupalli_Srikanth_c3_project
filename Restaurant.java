import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

public class Restaurant {
    public String getLocation() {
        return location;
    }

    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        LocalTime time = LocalTime.now();
        int value1 = openingTime.compareTo(time);
        int value2 = closingTime.compareTo(time);

        return value1 < 0 && value2 > 0;
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        for (Item item : menu) {
            List<Item> item1 = (List<Item>) item;
            return item1;
        }

        return null;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }

    public double totalcost() {
        ArrayList list = new ArrayList();
        Scanner input = new Scanner(System.in);
        getMenu();
        String choice;
        Double Total_cost = Double.valueOf(0);
        System.out.println("please select from menu :");
        choice = input.next();
        while (choice != "exit") {
            getMenu();
            list.add(choice);
            choice = input.next();
        }

        for (Object Selected_items : list) {
            System.out.println(Selected_items);
            int price = Item.getprice((String) Selected_items);
            Total_cost = price + Total_cost;


        }
        return Total_cost;
    }

}