
public class Group {
	
	private static int course = 0;
	private static int students = 0;
	private static String grade = "";
	private static int GPA = 0;
	
	public static int getNumCourses(){
		return course;
	}
	
	public static void setNumCourses(int nCourse){
		course = nCourse;
	}
	
	public static int getNumStudents(){
		return students;
	}
	
	public static void setNumStudents(int nStudents) {
		students = nStudents;
	}
	
	public static String getGrade(){
		return grade;
	}
	
	public static void setGrade(String nGrade) {
		grade = nGrade;
	}
	
	public static int getGPA() {
		return GPA;
	}
	
	public static void setGPA(int nGPA) {
		GPA = nGPA;
	}

}
