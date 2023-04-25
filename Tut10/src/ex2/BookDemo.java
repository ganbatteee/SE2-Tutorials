package ex2;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args) throws IllegalClassFormatException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter author's name: ");
            String author = scanner.nextLine();
            System.out.print("Enter the title: ");
            String title = scanner.nextLine();
            System.out.print("Enter the price: ");
            double price = Double.valueOf(scanner.nextLine());
            Book book = new Book(author, title, price);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);
            goldenEditionBook.setPrice(price);
            Method[] bookDeclaredMethods = Book.class.getDeclaredMethods();
            Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();
            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException(
                        "Code duplication in GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
