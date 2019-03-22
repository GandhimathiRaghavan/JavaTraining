package com.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;





public class StreamAPIEmployee {
	
	
	
	public static void main(String[] args) {

	
	final List<Employee> employees = new ArrayList<Employee>();

	employees.add(new Employee(1l, "Srinivas Kiran M", "CEO", 50000l,5015l));
	employees.add(new Employee(2l, "Ambadas Kshirsagar", "COO", 40000l,5013l));
	employees.add(new Employee(3l, "Vishnu Joshi", "SVP", 30000l,5012l));
	employees.add(new Employee(4l, "Prasad Varakur,", "Advisor", 20000l,5016l));
	employees.add(new Employee(5l, "Vinit Shah", "Advisor", 20000l,5014l));
	
	
	// SSN in Ascending order
				final List<Long> empSSNInAscendingOrder = employees.stream().map(employee -> employee.getSSN()).sorted().collect(Collectors.toList());
				System.out.println("Employee SSN in ascending order - " + empSSNInAscendingOrder);

	

				
	//SSN in Decnding orderused comparator in Streams			
	       final List<Long> empSSNInDecendingOrder = employees.stream().map(employee -> employee.getSSN()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				System.out.println("\nEmployee SSN in descending order - " + empSSNInDecendingOrder);
				
	
	
	//SSn Based on Comparator
			
				Collections.sort(employees,new MySSNComp());
		        System.out.println("\nSorted list entries based on SSN using Comparator:\n ");
		        for(Employee e:employees){
		        	
		        	System.out.println(e);
	    
	
	}
		        
		   //Employee::getSSN. or use comparing(Employee::getSSN)
		   
		        System.out.println("\n---Sorting using Comparator in Streams by SSN---\n");

				final List<Employee> slist = employees.stream().sorted(Comparator.comparingLong(e->e.getSSN())).collect(Collectors.toList());
				System.out.println("\nwithout forEach");
				System.out.println(slist);
				
				slist.forEach(e -> System.out.println(e));   
				
				/*employees.sort((o1,o2)->o2.getSSN().compareTo(o1.getSSN()));
				System.out.println(employees);*/
		      
}
}

//Comparator class
class MySSNComp implements Comparator<Employee>{
	 
    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getSSN() < e2.getSSN()){
            return 1;
        } else {
            return -1;
        }
    }
}


	class Employee {
		private Long id;
		private String name;
		private String designation;
		private Long salary;
	//added property SSn	
		private Long SSN;

		public Employee(Long id, String name, String designation, Long salary,Long SSN) {
			super();
			this.id = id;
			this.name = name;
			this.designation = designation;
			this.salary = salary;
			this.SSN=SSN;
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

		
		public Long getSSN() {
			return SSN;
		}

		public void setSSN(Long sSN) {
			SSN = sSN;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
					+ ", SSN=" + SSN + "]";
		}
	}



