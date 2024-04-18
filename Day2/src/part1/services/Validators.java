package part1.services;

import java.util.List;
import java.util.Optional;

import entities.Classes;
import entities.Gender;

public class Validators {

	public static boolean validatePincode(Long pincode) {
		if (pincode == null) {
			return false;
		}
		return true;
	}

	public static boolean validateGender(Gender gender) {
		if (gender == null)
			return false;
		return true;
	}

	public static boolean validateAge(Integer age) {
		if (age == null) {
			return false;
		}
		return true;
	}

	public static int validateCity(List<Classes> classData, String className) {
		if (className == null)
			return -1;

		return classData.stream().filter(c -> c.getClass_name().equalsIgnoreCase(className)).map(Classes::getClass_id).findFirst().get().intValue();
	}

}
