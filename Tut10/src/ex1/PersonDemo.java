package ex1;

import java.awt.print.Book;
import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class PersonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.valueOf(scanner.nextLine());
        try {
            Child child = new Child(name, age);
            child.setAge(age);
            child.displayChild();
          

        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

}
