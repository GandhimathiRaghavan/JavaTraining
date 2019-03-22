package com.javanewfeatures;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstanceMethodReferenceExample {

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

		final InstanceMethodReferenceExample employeeGenderImp = new InstanceMethodReferenceExample();
		final List<Employee> maleEmployees = employees.stream().filter(employeeGenderImp::isMaleEmployee)
				.collect(Collectors.toList());
		System.out.println("Male Employees are - " + maleEmployees);

	}
	
	public boolean isMaleEmployee(final Employee employee) {
		return "M".equalsIgnoreCase(employee.getGender());
	}

}
