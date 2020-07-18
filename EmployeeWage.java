import java.util.*;
class EmployeeWage {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Program");

		int empHour=0;
		int empRatePerHour=20;
		int empSalary=0;
		int partTime=0;
		int fullTime=1;

		double empPresent = Math.floor(Math.random() * 10) % 2;
		
		if ( empPresent == partTime ){
			System.out.println("Employee is part time Present");
			empHour=4;
		}
		
		if(empPresent == fullTime){
			System.out.println("Employee is Absent");
			empHour=8;
		}

		empSalary=empRatePerHour*empHour;
		
		System.out.println("Salary is :" + empSalary);
	}
}