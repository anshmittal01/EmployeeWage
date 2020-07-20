import java.util.*;
class EmployeeWage {

		public static int empRatePerHour=20;
		public static int workingDays=20;
		public static int workingHours=100;
		
		public static final int partTime=0;
		public static final int fullTime=1;
		
		private int empSalary=0;
		private int empTotalWorkingDays=0;
		private int empTotalWorkingHours=0;

		private double getRandom(){
			return Math.floor(Math.random() * 10) % 3;
		}

		private int getEmployeeHours(int empPresent){

			int employeeHour=0;
			switch(empPresent)
			{
				case partTime:
								employeeHour=4;
								break;
				case fullTime:
								employeeHour=8;
								break;
				default:
			}
			return employeeHour;
		}

		private void computeWage(){
			System.out.println("Welcome to Employee Wage Program");
			System.out.println("--------------------------------");
			System.out.println("day"+"\t\t"+"hours"+"\t"+"salary");
			
			while(empTotalWorkingDays<workingDays && empTotalWorkingHours<workingHours)
			{
				this.empTotalWorkingDays++;

				double empPresent = this.getRandom();
		
				int empHour = this.getEmployeeHours((int)empPresent);

				this.empTotalWorkingHours+=empHour;
				
				this.empSalary=this.empRatePerHour*this.empTotalWorkingHours;
				System.out.println(this.empTotalWorkingDays+"\t\t"+this.empTotalWorkingHours+"\t\t"+this.empSalary);
				
			}

				System.out.println("--------------------------------");
				System.out.println("Salary is :" + this.empSalary);
		}

	public static void main(String[] args) {
		EmployeeWage employeeWage = new EmployeeWage();
		employeeWage.computeWage();
		
	}
}