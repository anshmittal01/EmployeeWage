import java.util.*;
class EmployeeWage {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Program");

		final int isPresent=1;
		
		double empPresent = Math.floor(Math.random() * 10) % 2;
		if ( empPresent == isPresent )
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Absent");
	}
}