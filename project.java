import java.util.ArrayList;
import java.util.Scanner;

class Shoe {
    private String brand;
    private String model;
    private double price;

    public Shoe(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}

class Showroom {
    private ArrayList<Shoe> inventory;

    public Showroom() {
        this.inventory = new ArrayList<>();
    }

    public void addShoe(Shoe shoe) {
        inventory.add(shoe);
    }

    public void displayInventory() {
        System.out.println("Shoe Inventory:");
        for (Shoe shoe : inventory) {
            System.out.println(shoe);
        }
        System.out.println();
    }

    public void searchShoe(String brand) {
        System.out.println("Search Results for " + brand + ":");
        for (Shoe shoe : inventory) {
            if (shoe.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(shoe);
            }
        }
        System.out.println();
    }
}

public class project {
    public static void main(String[] args) {
        Showroom showroom = new Showroom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Shoe to Inventory");
            System.out.println("2. Display Inventory");
            System.out.println("3. Search for Shoes by Brand");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Shoe Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Shoe Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Shoe Price: ");
                    double price = scanner.nextDouble();

                    Shoe newShoe = new Shoe(brand, model, price);
                    showroom.addShoe(newShoe);
                    System.out.println("Shoe added to inventory successfully!\n");
                    break;

                case 2:
                    showroom.displayInventory();
                    break;

                case 3:
                    System.out.print("Enter Brand to Search: ");
                    String searchBrand = scanner.nextLine();
                    showroom.searchShoe(searchBrand);
                    break;

                case 4:
                    System.out.println("Exiting Shoe Showroom Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }
    }
}
