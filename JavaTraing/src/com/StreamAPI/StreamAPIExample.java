package com.StreamAPI;


	
	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Set;
	import java.util.stream.Collectors;

	public class StreamAPIExample {

		public static void main(String[] args) {

			final List<Employee> employees = new ArrayList<Employee>();

			employees.add(new Employee(1l, "Srinivas Kiran M", "CEO", 50000l));
			employees.add(new Employee(2l, "Ambadas Kshirsagar", "COO", 40000l));
			employees.add(new Employee(3l, "Vishnu Joshi", "SVP", 30000l));
			employees.add(new Employee(4l, "Prasad Varakur,", "Advisor", 20000l));
			employees.add(new Employee(5l, "Vinit Shah", "Advisor", 20000l));

			// find unique designations given to your employees
			final Set<String> uniqueDesignations = employees.stream().map(employee -> employee.getDesignation()).collect(Collectors.toSet());
			System.out.println("Unique Designations - " + uniqueDesignations);

			// find employees having salary greater or equal to 30,000
			final List<Employee> employeeWithSal30KOrMore = employees.stream().filter(employee -> employee.getSalary() >= 30000d).collect(Collectors.toList());
			System.out.println("Employees with salaray greater than or equal to 30,000 - " + employeeWithSal30KOrMore);

			// give 10% of hike to your employees
			final int hikePercentage = 10;
			employees.forEach(employee -> employee.hikeSalaryBy(hikePercentage));
			System.out.println("Employees with new salaries - " + employees);

			// employees names in sorted order
			final List<String> empNamesInAscendingOrder = employees.stream().map(employee -> employee.getName()).sorted().collect(Collectors.toList());
			System.out.println("Employee names in ascending order - " + empNamesInAscendingOrder);

			// employees names in sorted order
			final List<String> empNamesInDescendingOrder = employees.stream().map(employee -> employee.getName()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			System.out.println("Employee names in descending order - " + empNamesInDescendingOrder);

		}

	}

	class Employee {
		private Long id;
		private String name;
		private String designation;
		private Long salary;

		public Employee(Long id, String name, String designation, Long salary) {
			super();
			this.id = id;
			this.name = name;
			this.designation = designation;
			this.salary = salary;
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

		public void hikeSalaryBy(final int percentage) {
			this.salary += (this.salary * percentage / 100);
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
		}

	}


