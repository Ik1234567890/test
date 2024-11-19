public class addressbookExtended {
    public static void main(String[] args) {
        Person p1 = new Person("Eda", "45", "eda@gmail.com", "123-456-7890");
        p1.print();
        Person p2 = new Person("Hannah", "34", "hannah@gmail.com", "404-899-9955");
        p2.print();
        Person p3 = new Person("Maria", "19","ivaylo@gmail.com", "230-899-9955");
        p3.print();
        Person p4 = new Person("Ivaylo", "20","ivaylo@gmail.com", "450-899-9955");
        p4.print();


    }
}

class Person {
    private String name;
    private String age;
    private String email;
    private String phoneNumber;

    public Person(String initName, String initAge, String initEmail, String initPhone) {
        name = initName;
        age= initAge;
        email = initEmail;
        phoneNumber = initPhone;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);


    }

    public String getName() {
        return name;
    }
     public String getAge() {
        return age;
    }

     public String getPhoneNumber() {
        return phoneNumber;
    }

     public String getEmail() {
        return email;
    }
}
