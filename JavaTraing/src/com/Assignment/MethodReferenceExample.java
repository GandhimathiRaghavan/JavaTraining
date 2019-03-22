package com.Assignment;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MethodReferenceExample {

	public static void main(String[] args) {

		final List<Employee1> employees = new ArrayList<Employee1>();

		employees.add(new Employee1(1l, "Srinivas Kiran M", "CEO", 50000l, "M"));
		employees.add(new Employee1(2l, "Ambadas Kshirsagar", "COO", 40000l, "M"));
		employees.add(new Employee1(3l, "Vishnu Joshi", "SVP", 30000l, "M"));
		employees.add(new Employee1(4l, "Prasad Varakur,", "Advisor", 20000l, "M"));
		employees.add(new Employee1(5l, "Vinit Shah", "Advisor", 20000l, "M"));
		employees.add(new Employee1(6l, "Laxmi", "Developer", 10000l, "F"));
		employees.add(new Employee1(7l, "Sujatha", "QA", 10000l, "F"));
		employees.add(new Employee1(8l, "Anusha", "UX", 15000l, "F"));
		
		//Requirement1
		
		
		final List<Employee1> Developer = employees.stream()
				                                   .filter(EmployeeInterface::isDeveloper)
				                                   .collect(Collectors.toList());
		System.out.println("Developers is - " + Developer);
		
	
		
		//Requirement 2
		EmployeeInterface obj=new EmployeeInterface() {};
		final List<Employee1> employeeWithSal30KOrMore = employees.stream()
				                                                  .filter(obj::isSalaryGreaterThan20K)
				                                                  .filter(EmployeeInterface::isDeveloper)
				                                                  .collect(Collectors.toList());
		System.out.println("\n----Developer with salaray greater than or equal to 20,000 -\n " + employeeWithSal30KOrMore);

	}

}

interface EmployeeInterface {

	static boolean isDeveloper(final Employee1 emp) {
		return "Developer".equalsIgnoreCase(emp.getDesignation());
	}

	default boolean isSalaryGreaterThan20K(final Employee1 emp) {
		return emp.getSalary() >= 20000d;
	}

}

class Employee1 {
	private Long id;
	private String name;
	private String designation;
	private Long salary;
	private String gender;

	public Employee1(Long id, String name, String designation, Long salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public Long getSalary() {
		return salary;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", gender=" + gender + "]";
	}

	public int compare(final Employee1 o) {
		return this.getDesignation().compareToIgnoreCase(o.getDesignation());
	}

}
