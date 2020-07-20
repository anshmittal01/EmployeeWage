import java.util.*;
class EmployeeWage {

		public static final int partTime=0;
		public static final int fullTime=1;
		
		private String companyName;
		private int empRatePerHour;
		private int workingDays;
		private int workingHours;

		EmployeeWage(String companyName, int empRatePerHour, int workingDays, int workingHours){
			this.companyName=companyName;
			this.empRatePerHour=empRatePerHour;
			this.workingHours=workingHours;
			this.workingDays=workingDays;
		}


		private double getRandom(){
			return Math.floor(Math.random() * 10) % 3;
		}

		private int getEmployeeHours(int empPresent){

			int employeeHour=0;
			switch(empPresent)
			{
				case partTime:
								return 4;
				case fullTime:
								return 8;
				default:
								return 0;
			}
		}

		public void computeWage(){
			int empSalary=0;
			int empTotalWorkingDays=0;
			int empTotalWorkingHours=0;

			System.out.println("-----------------------------------------");
			System.out.println("Welcome to Employee Wage Program of "+this.companyName);
			System.out.println("-----------------------------------------");
			System.out.println("day"+"\t\t"+"hours"+"\t"+"salary");
			
			while(empTotalWorkingDays<workingDays && empTotalWorkingHours<workingHours)
			{
				empTotalWorkingDays++;

				double empPresent = this.getRandom();
		
				int empHour = this.getEmployeeHours((int)empPresent);

				empTotalWorkingHours+=empHour;
				
				empSalary=this.empRatePerHour*empTotalWorkingHours;
				System.out.println(empTotalWorkingDays+"\t\t"+empTotalWorkingHours+"\t\t"+empSalary);
				
			}

				System.out.println("--------------------------------");
				System.out.println("Salary is :" + empSalary+"\n\n\n");
		}

	public static void main(String[] args) {
		EmployeeWage ril = new EmployeeWage("RIL",20,20,100);
		EmployeeWage amazon = new EmployeeWage("AMAZON",20,20,100);
		EmployeeWage adobe = new EmployeeWage("ADOBE",20,20,100);
		ril.computeWage();
		amazon.computeWage();
		adobe.computeWage();
		
	}
}