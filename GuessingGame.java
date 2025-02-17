import java.util.Scanner;
import java.util.Random;


public class GuessingGame{
    public static void main (String[] args) {


        Scanner scanner= new Scanner (System.in);
        Random rand = new Random();
        int randomNumber= rand.nextInt (100) +1;
        System.out.println("Welcome to the Guessing Game. Try to guess the number I have in mind. It is between 1-100.If you want to quit the game type quit. Please enter a number bellow: ");
        int number = -1;
        int attempts = 0;
        do{
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                attempts++;
                System.out.println("You entered the number: " + number);
                if (number > randomNumber){
                    System.out.println("Your guess is too big. Try with a smaller number");
                } else if(number < randomNumber){
                    System.out.println("Your guess is too small. Try with a bigger number");
                }
            }else{
                String invalidInput = scanner.next(); // Consume the invalid input
                if(invalidInput.equals("quit")){
                    System.out.println("The correct number was " + randomNumber + " and you made " + attempts + " attempts. Thank you for playing!");
                    System.exit(0);
                }else{
                    System.out.println("Error: '" + invalidInput + "' is not a valid number.");
                }
            }
        }while (number != randomNumber);
        System.out.println("The correct number was indeed " + randomNumber);
        System.out.println("You made " + attempts + " attempts. Thank you for playing!");

    }
