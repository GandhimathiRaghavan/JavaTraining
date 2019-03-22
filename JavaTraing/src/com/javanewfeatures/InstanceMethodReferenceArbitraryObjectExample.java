package com.javanewfeatures;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstanceMethodReferenceArbitraryObjectExample {

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

		Collections.sort(employees, Employee::compare);
		System.out.println("Employees in sorting order (female first) are - " + employees);

	}

}

