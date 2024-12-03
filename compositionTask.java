public class compositionTask {
    public static void main(String[] args) {


        Car car= new Car("Ford", "V8", 18);
        car.displayInfo();
    }
}

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Wheel {
    private int size;

    public Wheel(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Car {
    private String brand;
    private String engine;
    private Wheel frontLeftWheel;
    private Wheel frontRightWheel;
    private Wheel rearLeftWheel;
    private Wheel rearRightWheel;

    public Car(String brand, String engine, int wheelSize) {
        this.brand = brand;
        this.engine = engine;
        this.frontLeftWheel = new Wheel(wheelSize);
        this.frontRightWheel = new Wheel(wheelSize);
        this.rearLeftWheel = new Wheel(wheelSize);
        this.rearRightWheel = new Wheel(wheelSize);
    }

    public void displayInfo() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Engine Type: " + engine);
        System.out.println("Front Left Wheel Size: " + frontLeftWheel.getSize() + " inches");
        System.out.println("Front Right Wheel Size: " + frontRightWheel.getSize() + " inches");
        System.out.println("Rear Left Wheel Size: " + rearLeftWheel.getSize() + " inches");
        System.out.println("Rear Right Wheel Size: " + rearRightWheel.getSize() + " inches");
    }
    class Brand {
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
}
