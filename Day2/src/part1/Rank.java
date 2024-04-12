package part1;

import java.util.List;

import entities.Student;

public class Rank {

	static List<Student> studentData;
	
	static int FIRST_RANK_MARKS;
	static int SECOND_RANK_MARKS;
	static int THIRD_RANK_MARKS;
	static int passingMarks;
	
	public Rank(List<Student> studentData, int passingMarks) {
		Rank.studentData = studentData;
		Rank.passingMarks = passingMarks;
	}
	
//	marks < 50 failed else passed
//	Give ranks to highest mark achievers.
//	Highest marks - First
	
	public String getResultStatus(Student s) {
		
		if(s.getMarks() < passingMarks) {
			return "Failed";
		}
		
		if(FIRST_RANK_MARKS < s.getMarks()) {
			FIRST_RANK_MARKS = s.getMarks();
		}
		if(FIRST_RANK_MARKS != s.getMarks() && SECOND_RANK_MARKS < s.getMarks()) {
			SECOND_RANK_MARKS = s.getMarks();
		}
		if(FIRST_RANK_MARKS != s.getMarks() && SECOND_RANK_MARKS != s.getMarks() && THIRD_RANK_MARKS < s.getMarks()) {
			THIRD_RANK_MARKS = s.getMarks();
		}
		
		if(s.getMarks() == FIRST_RANK_MARKS) {
			return "First";
		}
		if(s.getMarks() == SECOND_RANK_MARKS) {
			return "Second";
		}
		if(s.getMarks() == THIRD_RANK_MARKS) {
			return "Third";
		}
	
		return "Passed";	
		
	}
}
