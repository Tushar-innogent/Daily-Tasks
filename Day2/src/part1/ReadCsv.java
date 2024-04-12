package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import entities.Address;
import entities.Classes;
import entities.Student;

public class ReadCsv {

	// Collecting and storing data of the files
	static List<Classes> classData = new ArrayList<Classes>();
	static List<Student> studentData = new ArrayList<Student>();
	static List<Address> addressData = new ArrayList<Address>();

	// I should be able to read paginated students.
	// like : read female students first 1-9
	private static List<Student> fun1(String string, int start, int end) {

		ArrayList<Student> list = new ArrayList<Student>();

		studentData.forEach(s -> {
			if (s.getGender() == 'F' && s.getStudent_id() >= 1 && s.getStudent_id() <= 9) {
				list.add(s);
			}
		});
		return list;
	}

	private static void uploadAddress(String string) {

		// addressData = uploadDataToCollection(Address.class, string);

		String line = "";

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(string));

			line = bufferReader.readLine();

			while ((line = bufferReader.readLine()) != null) {

				Address address = new Address();

				String[] tempData = line.split(",");

				address.setAddress_id(Integer.parseInt(tempData[0]));
				address.setPin_Code(Long.parseLong(tempData[1]));
				address.setCity(tempData[2]);
				address.setStudent_id(Integer.parseInt(tempData[3]));

				addressData.add(address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void uploadClass(String string) {

		String line = "";

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(string));

			line = bufferReader.readLine();

			while ((line = bufferReader.readLine()) != null) {

				Classes classObj = new Classes();

				String[] tempData = line.split(",");

				classObj.setClass_id(Integer.parseInt(tempData[0]));
				classObj.setClass_name(tempData[1]);

				classData.add(classObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void uploadStudent(String string) {

		String line = "";

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(string));

			line = bufferReader.readLine();

			while ((line = bufferReader.readLine()) != null) {

				Student student = new Student();

				String[] tempData = line.split(",");

				student.setStudent_id(Integer.parseInt(tempData[0]));
				student.setStudent_name(tempData[1]);
				student.setClass_id(Integer.parseInt(tempData[2]));
				student.setMarks(Integer.parseInt(tempData[3]));
				student.setGender(Character.toUpperCase(tempData[4].toCharArray()[0]));
				student.setAge(Integer.parseInt(tempData[5]));

				studentData.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// general method to upload data from any file to any collection

	/*
	 * private static <T> HashSet<T> uploadDataToCollection (T entity, String file)
	 * {
	 * 
	 * String line = "";
	 * 
	 * HashSet<T> set = new HashSet<T>();
	 * 
	 * try { BufferedReader bufferReader = new BufferedReader(new FileReader(
	 * file));
	 * 
	 * // System.out.print(bufferReader);
	 * 
	 * while ((line = bufferReader.readLine()) != null) {
	 * 
	 * String[] data = line.split(",");
	 * 
	 * Address classObj = entity.getClass();
	 * 
	 * for(int i=1; i<data.length; i++) { // System.out.print(data[i]);
	 * 
	 * 
	 * 
	 * } // System.out.println();
	 * 
	 * } } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return null; }
	 */
	
	// Fail student whose age > 20
	private static List<Student> FailStudentByAge(int age) {
		
		return studentData.stream().filter(s->s.getAge()>age).peek(s-> s.setResultStatus("Failed")).collect(Collectors.toList());
		
	}
	
	static int id = 0;
	
	// Delete student 
	private static String deleteStudentById(int deleteById) {

		if(studentData.stream().filter(s-> s.getStudent_id() == deleteById).count() > 0) {
			
			Optional<Student> optional =  studentData.stream().filter(a->a.getStudent_id() == deleteById).findFirst();
			
			Student student = optional.get();
			
			studentData.remove(student);
			
			addressData = addressData.stream().filter(a->a.getStudent_id()!=deleteById).collect(Collectors.toList());
			
			return "Data Deleted";
		}
		
		
		return "Student doesn't exists with given id.";
	}

	//If there is no student remaining in that class. Class should also be deleted.
	private static String deleteClassIfHasNoStudent() {
		
		List<Integer> classIds = classData.stream().map(c->c.getClass_id()).collect(Collectors.toList());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		classIds.stream().forEach(c-> {
			map.put(c, 0);
		});
		
		studentData.stream().forEach(c-> {
			map.put(c.getClass_id(), map.getOrDefault(c.getClass_id(), 0)+1);
		});
		
		
	
		
		for(Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue().equals(0)) {
				id = (Integer)e.getKey();
			}
		}
		
//		System.out.println(map);
		
		if(id != 0) {
			classData  = classData.stream().filter(c -> c.getClass_id()!= id).collect(Collectors.toList());
			return "Class deleted whose id is "+id;
		}
		
		return "No class exist with no student ! ";
				
	}

	public static void main(String[] args) {

		uploadStudent(
				"C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Student.csv");
		uploadClass("C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Class.csv");
		uploadAddress(
				"C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Address.csv");

		// I should be able to read paginated students.
		// like : read female students first 1-9

		List<Student> result = fun1("F", 1, 9);
//		result.forEach(System.out::println);

		FilterData filterData = new FilterData(studentData, classData, addressData);

// 1. Find all students of pincode X(ex X = 482002). I can pass different filters like gender, age, class

		List<Student> filteredbyPincode = filterData.filterByPincode(studentData, 482002);
//		filteredbyPincode.forEach(System.out::println);

		
		
		
// 2. Find all students of city ex X = Indore. I can pass different filters like gender, age, class

		List<Student> filteredbyCity = filterData.filterByCity(studentData, "Indore");
//		filteredbyCity.forEach(System.out::println);

		// filter the filteredbyCity data by gender now
		List<Student> filteredByCityAndGender = filterData.filterByGender(filteredbyCity, 'F');
//		filteredByCityAndGender.forEach(System.out::println);
		
		
		

// 3. Give Ranking to students

		int passingMarks = 50;

		Rank rankObject = new Rank(studentData, passingMarks);

		Iterator<Student> iterator = studentData.iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			String resultStatus = rankObject.getResultStatus(s);
			s.setResultStatus(resultStatus);
		}

//		studentData.forEach(System.out::println);
		
		
		
		

//	4. Get the passed students. I can pass different filters like gender, age, class, city, pincode

		List<Student> passedStudents = studentData.stream().filter(s -> s.getMarks() >= passingMarks)
				.collect(Collectors.toList());

//		System.out.println("Passed Students : ");
//		passedStudents.stream().forEach(System.out::println);
		
		
		

//	5. Get the failed students. I can pass different filters like gender, age, class, city, pincode

//		System.out.println("Failed Students : ");
		
		List<Student> failedStudents = studentData.stream().filter(s -> s.getMarks() < passingMarks)
				.collect(Collectors.toList());

//		failedStudents.stream().forEach(System.out::println);
		
		
		

//	6. Find all student of class X (ex X = A).  I can pass different filters like gender, age, class, city, pincode
		
		List<Student> filteredByClass = filterData.filterByClass("A");
//		filteredByClass.forEach(System.out::println);
		
		
		
	
//	8. It should fail if student record is having age > 20.
		
		int age  = 20;
		FailStudentByAge(age);
		
//		studentData.forEach(System.out::println);
		
		
		
		
//	9. I should be able to delete student. After that it should delete the respective obj from Address & Student.
		
		//provide the id of the student to delete
		
		int deleteById = 2;
		
		String ans = deleteStudentById(deleteById);
		
//		System.out.println(ans);
		
//		studentData.forEach(System.out::println);
//		addressData.forEach(System.out::println);
		
		
		
//	10. If there is no student remaining in that class. Class should also be deleted.
		
		String message = deleteClassIfHasNoStudent();
//		System.out.println(message);
		
//		classData.forEach(System.out::println);
		
		
		
		
//	11. I should be able to .
//		like : read female students first 1-9
//		like : read female students first 7-8 order by name
//		like : read female students firread paginated studentsst 1-5 order by marks
//		like : read female students first 9-50 order by marks
		
		List<Student> filteredByGender = filterData.filterByGender(studentData, 'F');
		
		List<Student> paginatedData = filterData.readPaginated(filteredByGender, 1, 9);
		
// provide the sorting criteria name or marks 
		
		List<Student> sortPaginatedData = filterData.sortData(paginatedData, "marks");
		
		sortPaginatedData.forEach(System.out::println);
	}

	
	
	
}
