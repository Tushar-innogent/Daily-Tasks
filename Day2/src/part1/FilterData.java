package part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	// filter the data by pincode
	public static List filterByPincode(List<Student> studentData, long pincode) {

		List<Student> list = new ArrayList<Student>();
		List<Integer> sIdOfSelectedOnes = new ArrayList<Integer>();

		addressData.forEach(a -> {
			if (a.getPin_Code() == pincode) {
				sIdOfSelectedOnes.add(a.getStudent_id());
			}
		});

		studentData.forEach(s -> {
			if (sIdOfSelectedOnes.contains(s.getStudent_id())) {
				list.add(s);
			}
		});
		return list;
	}

	// filter the data by gender
	public static List filterByGender(List<Student> studentData, char gender) {

		List<Student> list = new ArrayList<Student>();

		studentData.forEach(s -> {
			if (s.getGender() == Character.toUpperCase(gender)) {
				list.add(s);
			}
		});
		return list;
	}

	// filter the data by age
	public static List filterByAge(List<Student> studentData, int age) {

		List<Student> list = new ArrayList<Student>();

		studentData.forEach(s -> {
			if (s.getAge() == age) {
				list.add(s);
			}
		});
		return list;
	}

	// filter students by city
	public static List<Student> filterByCity(List<Student> studentData, String city) {

		List<Student> byCity = new ArrayList<Student>();

		List<Integer> idsOfstudent = new ArrayList<Integer>();

		addressData.forEach(a -> {
			if (a.getCity().equalsIgnoreCase(city)) {
				idsOfstudent.add(a.getStudent_id());
			}
		});

		studentData.forEach(s -> {
			if (idsOfstudent.contains(s.getStudent_id())) {
				byCity.add(s);
			}
		});
		return byCity;
	}

	public static List<Student> filterByClass(String className) {

		Optional<Classes> optional = classData.stream().filter(s -> className.equalsIgnoreCase(s.getClass_name()))
				.peek(e -> e.getClass_id()).findFirst();

		Classes classes = optional.get();

		List<Student> filteredByClass = studentData.stream().filter(s -> s.getClass_id() == classes.getClass_id())
				.collect(Collectors.toList());

		return filteredByClass;
	}

//	read paginated students
	public static List<Student> readPaginated(List<Student> studentData, int start, int end) {

		List<Student> students = studentData.stream()
				.filter(s -> (s.getStudent_id() >= start && s.getStudent_id() <= end)).collect(Collectors.toList());

		return students;
	}

	public static List<Student> sortData(List<Student> data, String sortBy) {
		
		return data.stream().sorted(getComparator(sortBy)).collect(Collectors.toList());

	}

	private static Comparator<Student> getComparator(String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "name":
                return Comparator.comparing(Student::getStudent_name);
            case "marks":
                return Comparator.comparingInt(Student::getMarks).reversed();
            default:
                return Comparator.comparingInt(Student::getStudent_id);
        }
	}
}
