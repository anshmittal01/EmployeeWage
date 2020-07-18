import java.util.*;
class EmployeeWage {

		static int empHour=0;
		static int empRatePerHour=20;
		static int workingDays=20;
		static int workingHours=100;
		
		static final int partTime=0;
		static final int fullTime=1;
		
		static int empSalary=0;
		static int empTotalWorkingDays=0;
		static int empTotalWorkingHours=0;

		static double getRandom(){
			return Math.floor(Math.random() * 10) % 3;
		}

		static int getEmployeeHours(int empPresent){

			int employeeHour=0;
			switch(empPresent)
			{
				case partTime:
								System.out.println("Employee is part time Present");
								employeeHour=4;
								break;
				case fullTime:
								System.out.println("Employee is full time Present");
								employeeHour=8;
								break;
				default:
								System.out.println("Employee is Absent");
			}
			return employeeHour;
		}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Program");

		while(empTotalWorkingDays<workingDays && empTotalWorkingHours<workingHours)
		{
			empTotalWorkingDays++;

			double empPresent = getRandom();
	
			empHour = getEmployeeHours((int)empPresent);

			empTotalWorkingHours+=empHour;
			
			empSalary=empRatePerHour*empTotalWorkingHours;
			
		}
			System.out.println("Salary is :" + empSalary);
	}
}