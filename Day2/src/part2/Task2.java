package part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {

	static int ageSumOfMale;
	static int ageSumOfFemale;

	static long maleCount;
	static long femaleCount;
	
	static long salarySumOfMale;
	static long salarySumOfFemale;

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//1.	How many male and female employees are there in the organization?

		countMaleAndFemale(employeeList);

//		System.out.println("Male Employees : "+maleCount);
//		System.out.println("Female Employees : "+femaleCount);
		
		
		
//2.	Print the name of all departments in the organization?
		
		Set<String> departmentList = employeeList.stream().map(e-> e.getDepartment()).collect(Collectors.toSet());
//		departmentList.forEach(System.out::println);
		
		
		
//3.	What is the average age of male and female employees?
		
		findAverageAge(employeeList);
		
//		System.out.println("Average age of males is "+(ageSumOfMale/maleCount));
//		System.out.println("Average age of females is "+(ageSumOfFemale/femaleCount));
		
		
		
//4.	Get the details of highest paid employee in the organization?

		Employee employee = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();
		
//		System.out.println("Highest paid Employee details : \n"+employee);
		
		
		
//5.	Get the names of all employees who have joined after 2015?
		List<Employee> EmployeeAfter2015 = employeeList.stream().filter(e-> e.getYearOfJoining() > 2015).collect(Collectors.toList());
//		EmployeeAfter2015.forEach(System.out::println);
		
		
		
		
//6.	Count the number of employees in each department?
		Map<String, Integer> countInDepartment = employeesInDept(employeeList);
		
//		System.out.println("Department => Number of employees");
//		for(Entry<String, Integer> e : countInDepartment.entrySet()) {
//			System.out.println(e.getKey() +" => "+e.getValue());	
//		}
		
		
		
		
//7		What is the average salary of each department?
		Map<String, Integer> avgSalDept = getAverageSalOfDept(employeeList);
		
//		for(Entry<String, Integer> e : avgSalDept.entrySet()) {
//		System.out.println(e.getKey() +" => "+e.getValue());	
//		}
		
		
//8		Get the details of youngest male employee in the product development department?
		
		Employee youngestEmployee = employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).findFirst().get();
//		System.out.println(youngestEmployee);
	
		
		
//9		How many male and female employees are there in the sales and marketing team?
		

		long males = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Male") && (e.getDepartment().equalsIgnoreCase("Sales") || e.getDepartment().equalsIgnoreCase("Marketing"))).count();
		long females = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("female") && (e.getDepartment().equalsIgnoreCase("Sales") || e.getDepartment().equalsIgnoreCase("Marketing"))).count();
		
//		System.out.println("Male employees in sales and marketing = "+males);
//		System.out.println("Female employees in sales and marketing = "+females);

		
//10.	What is the average salary of male and female employees?
		
		
		employeeList.stream().filter(e-> e.getGender().equalsIgnoreCase("male")).peek(s->salarySumOfMale+=s.getSalary());
		employeeList.stream().filter(e-> e.getGender().equalsIgnoreCase("female")).peek(s->salarySumOfFemale+=s.getSalary());
				
//		System.out.println("Average salary of male employees = "+ (salarySumOfMale)/maleCount);
//		System.out.println("Average salary of female employees = "+ (salarySumOfFemale)/femaleCount);
	
		
		
//11	List down the names of all employees in each department?
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		departmentList.forEach(d->{
			List<String> names = new ArrayList<String>();
			names = employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase(d)).map(e->e.getName()).collect(Collectors.toList());
			map.put(d, names);
//			System.out.println(names);
		});
		
		for(Entry e : map.entrySet()) {
			System.out.println(e.getKey()+"  : "+e.getValue());
		}
						
//		What is the average salary and total salary of the whole organization?
		
//		Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?

//		Who is the oldest employee in the organization? What is his age and which department he belongs to?
	}

	private static Map<String, Integer> employeesInDept(List<Employee> employeeList) {

		Map<String, Integer> countInDepartment = new HashMap<String, Integer>();
		employeeList.stream().forEach(e -> countInDepartment.put(e.getDepartment(),
				countInDepartment.getOrDefault(e.getDepartment(), 1) + 1));

		return countInDepartment;

	}

	private static Map<String, Integer> getAverageSalOfDept(List<Employee> employeeList) {

		Map<String, Integer> mapDeptAgeSum = new HashMap<String, Integer>();
		employeeList.stream().forEach(e -> mapDeptAgeSum.put(e.getDepartment(),
				mapDeptAgeSum.getOrDefault(e.getDepartment(), 0) + e.getAge()));

		Map<String, Integer> countEmpInDepartment = employeesInDept(employeeList);

		mapDeptAgeSum.entrySet().stream()
				.forEach(e -> mapDeptAgeSum.remove(e.getKey(), (e.getValue() / countEmpInDepartment.get(e.getKey()))));

		return mapDeptAgeSum;
	}

	private static void findAverageAge(List<Employee> employeeList) {

		employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("male"))
				.forEach(e -> ageSumOfMale += e.getAge());
		employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("female"))
				.forEach(e -> ageSumOfFemale += e.getAge());

	}

	private static void countMaleAndFemale(List<Employee> employeeList) {

		maleCount = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Male")).count();
		femaleCount = employeeList.size() - maleCount;

	}

}
