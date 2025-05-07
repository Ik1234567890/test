import java.io.*;
import java.util.Scanner;

public class GroceryList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the file to save your grocery list: ");
        String fileName = input.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            System.out.println("Enter your grocery items one by one. Type 'done' when finished:");

            while (true) {
                System.out.print("Item: ");
                String item = input.nextLine();

                if (item.equalsIgnoreCase("done")) {
                    break;
                }

                writer.println(item);
            }

            System.out.println("Your grocery list has been saved to " + fileName);

        } catch (IOException e) {
            System.out.println("There was an error writing to the file: " + e.getMessage());
        }
    }
}
