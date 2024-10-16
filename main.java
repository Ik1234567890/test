import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner= new Scanner(System.in);
int secret = 5;
System.out.println("Guess a number between 1-10 ");
int attempt1= scanner.nextInt();

if (attempt1==secret) {
    System.out.println("Congrats! You guessed correct ");
}
else if (attempt1>secret){
    System.out.println("Wrong.Guess lower ");
}
else {
    System.out.println("Wrong.Guess higher ");
}
int attempt2 = scanner.nextInt();

if (attempt2 ==secret) {
    System.out.println("Congrats! You guessed correct ");
}
else if (attempt2 >secret){
    System.out.println("Wrong. Guess lower ");
}
else {
    System.out.println("Wrong. Guess higher ");
}
int attempt3 = scanner.nextInt();

if (attempt3 ==secret) {
    System.out.println("Congrats! You guessed correct ");
}
else if (attempt3 >secret){
    System.out.println("Wrong. The number was lower. Unfortunately this was your last attempt ");
}
else {
    System.out.println("Wrong. The number was higher. Unfortunately this was your last attempt ");
}

        }
    }
