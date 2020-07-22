import java.util.*;
class CompanyEmployeeWage{

    private String companyName;
    private int empRatePerHour;
    private int workingDays;
    private int workingHours;
    private int totalWage;
    private ArrayList<Integer> dailyWage;

    CompanyEmployeeWage(String companyName, int empRatePerHour, int workingDays, int workingHours){
        this.companyName=companyName;
        this.empRatePerHour=empRatePerHour;
        this.workingHours=workingHours;
        this.workingDays=workingDays;
        this.dailyWage=new ArrayList<Integer>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmpRatePerHour() {
        return empRatePerHour;
    }

    public void setEmpRatePerHour(int empRatePerHour) {
        this.empRatePerHour = empRatePerHour;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public void addToDailyWage(int employeeWage)
	{
		this.dailyWage.add(employeeWage);
	}

	public ArrayList<Integer> getDailyWage()
	{
		return this.dailyWage;
	}
}

class EmployeeWage {

		public static final int partTime=0;
		public static final int fullTime=1;
		ArrayList<CompanyEmployeeWage> companyEmployeeWageArray ;
		HashMap<String,CompanyEmployeeWage> totalWageMap;

		public EmployeeWage(){
				companyEmployeeWageArray = new ArrayList<CompanyEmployeeWage>();
				totalWageMap = new HashMap<String,CompanyEmployeeWage>(); 
		}
	
		private void addCompany(String company, int empRatePerHr, int maxHrsPerMonth, int numWorkingDays){
			CompanyEmployeeWage companyEmployeeWage = new CompanyEmployeeWage(company,empRatePerHr,maxHrsPerMonth,numWorkingDays);
			companyEmployeeWageArray.add(companyEmployeeWage);
			totalWageMap.put(company,companyEmployeeWage);
		}

		private double getRandom(){
			return Math.floor(Math.random() * 10) % 3;
		}

		private int getEmployeeHours(int empPresent){

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

		public void computeWageForAll(){
			for(CompanyEmployeeWage emp:companyEmployeeWageArray){
				int totalWage = this.computeWage(emp);
				emp.setTotalWage(totalWage);
			}
		}

		public void getTotalWage(String companyName)
		{
			System.out.println("Total Wage for "+companyName+" is:- "+totalWageMap.get(companyName).getTotalWage());
		}


		public int computeWage(CompanyEmployeeWage employeeWage){
			int empSalary=0;
			int empTotalWorkingDays=0;
			int empTotalWorkingHours=0;

			System.out.println("-----------------------------------------");
			System.out.println("Welcome to Employee Wage Program of "+employeeWage.getCompanyName());
			System.out.println("-----------------------------------------");
			System.out.println("day"+"\t\t"+"hours"+"\t"+"salary");
			
			while(empTotalWorkingDays<employeeWage.getWorkingDays() && empTotalWorkingHours<employeeWage.getWorkingHours())
			{
				empTotalWorkingDays++;

				double empPresent = this.getRandom();
		
				int empHour = this.getEmployeeHours((int)empPresent);

				empTotalWorkingHours+=empHour;
				
				empSalary=employeeWage.getEmpRatePerHour()*empTotalWorkingHours;
				employeeWage.addToDailyWage(empHour*employeeWage.getEmpRatePerHour());
				System.out.println(empTotalWorkingDays+"\t\t"+empTotalWorkingHours+"\t\t"+empSalary);
				
			}

				System.out.println("--------------------------------");
				System.out.println("Salary is :" + empSalary+"\n\n\n");
			return empSalary;
		}

	public static void main(String[] args) {
		EmployeeWage employeeWage = new EmployeeWage();
		employeeWage.addCompany("RIL",20,20,100);
		employeeWage.addCompany("AMAZON",20,20,100);
		employeeWage.addCompany("ADOBE",20,20,100);
		
		employeeWage.computeWageForAll();

		employeeWage.getTotalWage("RIL");
	}
}