import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private String customerId;
    private String name;
    private String checkInDate;
    private String checkOutDate;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void selectDates(String checkInDate, String checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
}

class HotelManager {
    public void bookRoom(Customer customer) {
        // In a complete system, you would handle booking and messaging here.
        // You might save booking details in a file or database, and send a confirmation message to the customer.
        System.out.println("Room booked for " + customer.getName() +
                " (Customer ID: " + customer.getCustomerId() +
                ") from " + customer.getCheckInDate() + " to " + customer.getCheckOutDate());
    }
}

public class HotelManagement{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        HotelManager hotelManager = new HotelManager();

        while (true) {
            System.out.println("1. New Customer");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Customer ID: ");
                String customerId = scanner.nextLine();
                System.out.print("Enter Customer Name: ");
                String customerName = scanner.nextLine();
                customers.add(new Customer(customerId, customerName));
                System.out.println("Customer registered.");
            } else if (choice == 2) {
                System.out.print("Enter Customer ID: ");
                String customerId = scanner.nextLine();
                Customer customer = findCustomer(customers, customerId);

                if (customer == null) {
                    System.out.println("Customer not found.");
                } else {
                    System.out.print("Enter Check-in Date: ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Enter Check-out Date: ");
                    String checkOutDate = scanner.nextLine();
                    customer.selectDates(checkInDate, checkOutDate);
                    hotelManager.bookRoom(customer);
                }
            } else if (choice == 3) {
                break;
            }
        }
    }

    private static Customer findCustomer(List<Customer> customers, String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
}