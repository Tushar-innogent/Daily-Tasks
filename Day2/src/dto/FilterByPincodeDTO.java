package dto;

import entities.Gender;

public class FilterByPincodeDTO {
	private Long pincode;
	private Gender gender;
	private Integer age;
	private String className;
	
	public FilterByPincodeDTO(Long pincode, Gender gender, Integer age, String className) {
		super();
		this.pincode = pincode;
		this.gender = gender;
		this.age = age;
		this.className = className;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}	