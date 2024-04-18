package part1.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.FilterByPincodeDTO;
import entities.Address;
import entities.Classes;
import entities.Student;

public class FilterData {

	static List<Student> studentData;
	static List<Classes> classData;
	static List<Address> addressData;

	static int classId;
	static int studentId;
	static int addressId;

	public FilterData(List<Student> studentData, List<Classes> classData, List<Address> addressData) {
		FilterData.studentData = studentData;
		FilterData.classData = classData;
		FilterData.addressData = addressData;
	}

	// 1.Find all students of pincode X(ex X = 482002). I can pass different filters
	// like gender, age, class
	public static List<Student> filterByPincode(List<Student> studentData, FilterByPincodeDTO dto) {
		return studentData.parallelStream().filter(s -> addressData.stream()
				.filter(a -> (Validators.validatePincode(dto.getPincode()) ? a.getPinCode() == dto.getPincode() :false ))
				.map(Address::getStudentId).toList().contains(s.getStudentId()))
				.filter(s->(Validators.validateGender(dto.getGender()) ? dto.getGender().equals(s.getGender()):false)
				&& (Validators.validateAge(dto.getAge()) ? dto.getAge().equals(s.getAge()) : false)
				&& (Validators.validateCity(classData, dto.getClassName()) == s.getClassId()))
				.toList();
	}

	// filter the data by gender
	public static List<Student> filterByGender(List<Student> studentData, char gender) {

		List<Student> list = new ArrayList<Student>();

		studentData.forEach(s -> {
//			if (s.getGender() == Character.toUpperCase(gender)) {
//				list.add(s);
//			}
		});
		return list;
	}

	// filter the data by age
	public static List<Student> filterByAge(List<Student> studentData, int age) {

		List<Student> list = new ArrayList<Student>();

		studentData.forEach(s -> {
			if (s.getAge() == age) {
				list.add(s);
			}
		});
		return list;
	}

	// 2. Find all students of city ex X = Indore. I can pass different filters like
	// gender, age, class
	public static List<Student> filterByCity(List<Student> studentData, String city) {

		List<Student> byCity = new ArrayList<Student>();

		List<Integer> idsOfstudent = new ArrayList<Integer>();

		addressData.forEach(a -> {
			if (a.getCity().equalsIgnoreCase(city)) {
				idsOfstudent.add(a.getStudentId());
			}
		});

		studentData.forEach(s -> {
			if (idsOfstudent.contains(s.getStudentId())) {
				byCity.add(s);
			}
		});
		return byCity;
	}

//	6. Find all student of class X (ex X = A).  I can pass different filters like gender, age, class, city, pincode
	public static List<Student> filterByClass(String className) {

		Optional<Classes> optional = classData.stream().filter(s -> className.equalsIgnoreCase(s.getClass_name()))
				.peek(e -> e.getClass_id()).findFirst();

		Classes classes = optional.get();

		List<Student> filteredByClass = studentData.stream().filter(s -> s.getClassId() == classes.getClass_id())
				.collect(Collectors.toList());

		return filteredByClass;
	}

//	read paginated students
	public static List<Student> readPaginated(List<Student> studentData, int start, int end) {

		List<Student> students = studentData.stream()
				.filter(s -> (s.getStudentId() >= start && s.getStudentId() <= end)).collect(Collectors.toList());

		return students;
	}

	public static List<Student> sortData(List<Student> data, String sortBy) {

		return data.stream().sorted(getComparator(sortBy)).collect(Collectors.toList());

	}

	private static Comparator<Student> getComparator(String sortBy) {
		switch (sortBy.toLowerCase()) {
		case "name":
			return Comparator.comparing(Student::getStudentName);
		case "marks":
			return Comparator.comparingInt(Student::getMarks).reversed();
		default:
			return Comparator.comparingInt(Student::getStudentId);
		}
	}
}
