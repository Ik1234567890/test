import java.util.Scanner;
public class CarGallery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] carArray = {
                new Car("Toyota", "Camry", 2020, 25000),
                new Car("Honda", "Civic", 2021, 22000),
                new Car("Ford", "Fusion", 2019, 27000),
                new Car("BMW", "X5", 2022, 55000)
        };

        System.out.println("All Cars in the Gallery:");
        displayAllCars(carArray);

        System.out.println("\nMost Expensive Car:");
        findMostExpensiveCar(carArray).displayInfo();

        System.out.println("\nAverage Price: $" + calculateAveragePrice(carArray));

        int choice;
        do {
            System.out.println("\nEnter the number of the car you want to lease (1-" + carArray.length + "):");
            choice = scanner.nextInt() - 1;
        } while (!leaseCar(carArray, choice));

        System.out.println("\nUpdated Car Gallery:");
        displayAllCars(carArray);

        scanner.close();
    }

    public static void displayAllCars(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print((i + 1) + ". ");
            cars[i].displayInfo();
        }
    }

    public static Car findMostExpensiveCar(Car[] cars) {
        Car mostExpensive = cars[0];
        for (Car car : cars) {
            if (car.price > mostExpensive.price) {
                mostExpensive = car;
            }
        }
        return mostExpensive;
    }

    public static double calculateAveragePrice(Car[] cars) {
        double sum = 0;
        for (Car car : cars) {
            sum += car.price;
        }
        return sum / cars.length;
    }

    public static boolean leaseCar(Car[] cars, int index) {
        if (index >= 0 && index < cars.length) {
            return cars[index].leaseCar();
        } else {
            System.out.println("Invalid car selection.");
            return false;
        }
    }
}
class Car {
    String make;
    String model;
    int year;
    double price;
    boolean isLeased;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = false; // Default to not leased
    }

    public void displayInfo() {
        System.out.println(make + " " + model + " (" + year + ") - $" + price + " - Leased: " + isLeased);
    }

    public boolean leaseCar() {
        if (!isLeased) {
            isLeased = true;
            System.out.println(make + " " + model + " has been leased.");
            return true;
        } else {
            System.out.println(make + " " + model + " is already leased.");
            return false;
        }
    }
}
