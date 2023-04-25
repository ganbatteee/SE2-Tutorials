package to_dos.factory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Create the CourseInformation class to generate information about the duration 
 * and fee of the course by using the Admission class to get the object of 
 * sub-classes by passing the required information like the course being applied for */
class CourseInformation {
	public static void main(String args[]) throws IOException {
		//TO-DO: Create new Admission object
		Admission admission = new Admission();

		//TO-DO: Get user's input for the course's name
		admission.admittingCourse("Civil Service");
		admission.admittingCourse("Computer");
		admission.admittingCourse("Health");

		System.out.print("Enter a course you want to learn: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String courseName = br.readLine();

		Course course = admission.admittingCourse(courseName);
		course.getDuration();
		course.getFeePerSemester();
		course.calculateTotalFee();

		System.out.println("=======================================");
		//TO-DO: Create new course with created Admission
		Health health = (Health) new Admission().admittingCourse("Health");

		//TO-DO: Display the require duration in semesters, required fee per semester and for whole course
		health.getDuration();
		health.getFeePerSemester();
		health.calculateTotalFee();

		CivilService civilService = (CivilService) new Admission().admittingCourse("Civil Service");

		//TO-DO: Display the require duration in semesters, required fee per semester and for whole course
		civilService.getDuration();
		civilService.getFeePerSemester();
		civilService.calculateTotalFee();

		Computer computer = (Computer) new Admission().admittingCourse("Computer");

		//TO-DO: Display the require duration in semesters, required fee per semester and for whole course
		computer.getDuration();
		computer.getFeePerSemester();
		computer.calculateTotalFee();



	}
}  