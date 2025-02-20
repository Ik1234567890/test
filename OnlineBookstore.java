import java.util.Scanner;
public class OnlineBookstore {
    static String[] titles = {"Java Programming", "Python Basics", "C++ Fundamentals", "Data Structures", "Algorithms"};
    static double[] prices = {39.99, 29.99, 34.99, 24.99, 44.99};
    static int[] quantities = {10, 8, 5, 7, 6};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayBooks();
            System.out.println("Enter the book number to purchase or 0 to exit:");
            int selection = scanner.nextInt();
            scanner.nextLine();
            if (selection == 0) {
                running = false;
                System.out.println("Exiting the program. Thank you!");
            } else if (selection >= 1 && selection <= titles.length) {
                if (quantities[selection - 1] > 0) {
                    System.out.println("You selected: " + titles[selection - 1]);
                    System.out.println("Price: $" + prices[selection - 1]);
                    System.out.print("Insert money: $");
                    double insertedMoney = scanner.nextDouble();

                    if (insertedMoney >= prices[selection - 1]) {
                        quantities[selection - 1]--;
                        double change = insertedMoney - prices[selection - 1];
                        System.out.println("Book purchased: " + titles[selection - 1]);
                        System.out.println("Your change: $" + change);
                    } else {
                        System.out.println("Insufficient funds. Please insert more money.");
                    }
                } else {
                    System.out.println("Sorry, that book is out of stock.");
                }
            } else {
                System.out.println("Invalid selection. Please choose a valid book number.");
            }
        }
    }
    public static void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " - $" + prices[i] + " (Stock: " + quantities[i] + ")");
        }
    }
}
