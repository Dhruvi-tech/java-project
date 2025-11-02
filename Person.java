/*
 * How to run this program:
 * 1. Compile: javac Person.java
 * 2. Run: java Person
 * 
 * Last updated: November 2025
 * Contributor: Dhruvi
 */
public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean isAdult() {
        return age >= 18;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %3d", name, age);
    }
    
    public static void main(String[] args) {
        Person[] persons = {
            new Person("Alice Johnson", 19),
            new Person("Bob Wilson", 17),
            new Person("David Garcia", 19),
            new Person("Emma Davis", 18),
            new Person("James Taylor", 17),
            new Person("John Smith", 18),
            new Person("Lisa Anderson", 18),
            new Person("Maria Rodriguez", 19),
            new Person("Mike Brown", 19),
            new Person("Sarah Miller", 17)
        };
        
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.printf("%-20s %s%n", "Name", "Age");
        System.out.println("--------------------------");
        
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("--------------------------");
        System.out.println("Total Students: " + persons.length);
    }
}