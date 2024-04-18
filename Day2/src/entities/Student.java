package entities;

public class Student {

	private int studentId;
	private String studentName;
	private int classId;
	private int marks;
	private Gender gender;
	private int age;
	private String resultStatus;
	
	public Student(int studentId, String studentName, int classId, int marks, Gender gender, int age,
			String resultStatus) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.marks = marks;
		this.gender = gender;
		this.age = age;
		this.resultStatus = resultStatus;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", classId=" + classId
				+ ", marks=" + marks + ", gender=" + gender + ", age=" + age + ", resultStatus=" + resultStatus + "]";
	}	
}
