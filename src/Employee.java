package src;
import java.io.*;
import java.util.*;
public class Employee {
    private String lastName;
    private String firstName;
    private int age;
    public Employee(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return lastName + " " + firstName + ", age: " + age;
    }
}
