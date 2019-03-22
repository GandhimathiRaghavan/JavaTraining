package com.javanewfeatures;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticMethodReferenceExample {

	public static void main(String[] args) {

		final List<Employee> employees = new ArrayList<Employee>();

		employees.add(new Employee(1l, "Srinivas Kiran M", "CEO", 50000l, "M"));
		employees.add(new Employee(2l, "Ambadas Kshirsagar", "COO", 40000l, "M"));
		employees.add(new Employee(3l, "Vishnu Joshi", "SVP", 30000l, "M"));
		employees.add(new Employee(4l, "Prasad Varakur,", "Advisor", 20000l, "M"));
		employees.add(new Employee(5l, "Vinit Shah", "Advisor", 20000l, "M"));
		employees.add(new Employee(6l, "Laxmi", "Developer", 10000l, "F"));
		employees.add(new Employee(7l, "Sujatha", "QA", 10000l, "F"));
		employees.add(new Employee(8l, "Anusha", "UX", 15000l, "F"));

		final List<Employee> femaleEmployees = employees.stream().filter(EmployeeGenderInterface::isFemaleEmployee)
				.collect(Collectors.toList());
		System.out.println("Female Employees are - " + femaleEmployees);

	}

}

interface EmployeeGenderInterface {

	static boolean isFemaleEmployee(final Employee emp) {
		return "F".equalsIgnoreCase(emp.getGender());
	}

	default boolean isMaleEmployee(final Employee emp) {
		return "M".equalsIgnoreCase(emp.getGender());
	}

}

class Employee {
	private Long id;
	private String name;
	private String designation;
	private Long salary;
	private String gender;

	public Employee(Long id, String name, String designation, Long salary, String gender) {
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

	public int compare(final Employee o) {
		return this.getGender().compareToIgnoreCase(o.getGender());
	}

}
