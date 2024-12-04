
public class ZooTask {
    public static void main(String[] args) {
        Habitat h1 = new Habitat("Savannah", 10000, 30);
        Habitat h2 = new Habitat("Forest", 10000, 20);

        Staff s1 = new Staff("Dichev", "Cleaner", "Forest");
        Staff s2 = new Staff("Arabajiev", "Guard", "Savannah");

        Zoo z1 = new Zoo();
        z1.addAnimal1();
        z1.addAnimal2();
        z1.addAnimal3();
        z1.addAnimal4();

        s1.setAssignedHabitat(h1);
        s2.setAssignedHabitat(h2);

        z1.a1.Eat("pork", s1);
        z1.a2.Eat("chicken", s2);
        z1.a3.Eat("human", s1);
        z1.a4.Eat("Ivaylo", s2);
    }
}

class Animal {
    private String animalName;
    private String animalSpecies;
    private int animalAge;
    private String animalHabitat;

    public Animal(String animalName, String animalSpecies, int animalAge, String animalHabitat) {
        this.animalName = animalName;
        this.animalSpecies = animalSpecies;
        this.animalAge = animalAge;
        this.animalHabitat = animalHabitat;
    }

    public void Eat(String food, Staff staff) {
        System.out.println(this.animalName + " was fed " + food + " by " + staff.getName());
    }
}

class Habitat {
    private String habitatType;
    private int habitatSize;
    private int habitatTemperature;

    public Habitat(String type, int size, int temperature) {
        this.habitatType = type;
        this.habitatSize = size;
        this.habitatTemperature = temperature;
    }

    public String getType() {
        return habitatType;
    }
}

class Zoo {
    Animal a1;
    Animal a2;
    Animal a3;
    Animal a4;

    void addAnimal1() {
        a1 = new Animal("Ivaylo", "wolf", 17, "Forest");
    }

    void addAnimal2() {
        a2 = new Animal("Maria", "zebra", 15, "Savannah");
    }

    void addAnimal3() {
        a3 = new Animal("Kamen", "bear", 50, "Savannah");
    }

    void addAnimal4() {
        a4 = new Animal("Bogdan", "lion", 20, "Savannah");
    }
}

class Staff {
    private String staffName;
    private String staffRole;
    private Habitat assignedHabitat;

    public Staff(String staffName, String staffRole, String assignedHabitat) {
        this.staffName = staffName;
        this.staffRole = staffRole;
    }

    public void setAssignedHabitat(Habitat habitat) {
        this.assignedHabitat = habitat;
        System.out.println(staffName + " is assigned to " + assignedHabitat.getType());
    }

    public String getName() {
        return staffName;
    }

    public Habitat getAssignedHabitat() {
        return assignedHabitat;
    }
}
