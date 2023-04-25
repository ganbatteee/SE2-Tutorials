package ex3;

import ex1.Child;
import ex1.Person;

import java.util.Scanner;

public class HumanDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's firstname: ");
        String firstnameStu = sc.nextLine();
        System.out.print("Enter student's lastname: ");
        String lastnameStu = sc.nextLine();

        System.out.print("Enter worker's firstname: ");
        String firstnameWorker = sc.nextLine();
        System.out.print("Enter worker's lastname: ");
        String lastnameWorker = sc.nextLine();

        System.out.print("Enter facultyNumber: ");
        int facultyNumber = sc.nextInt();
        System.out.print("Enter week salary: ");
        double weekSalary = sc.nextDouble();
        System.out.print("Enter working hours: ");
        double workingHours = sc.nextDouble();

        try {
            Student student = new Student(firstnameStu, lastnameStu, facultyNumber);
            System.out.println(student.toString());

            Worker worker = new Worker(firstnameWorker, lastnameWorker, weekSalary, workingHours);
            worker.setWeekSalary(weekSalary);
            worker.setWorkingHours(workingHours);
            System.out.println(worker.toString());

            String studentClassName = Student.class.getSimpleName();
            String workerClassName = Worker.class.getSimpleName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }

    }
}
