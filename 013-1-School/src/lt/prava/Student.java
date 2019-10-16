package lt.prava;

public class Student extends Human {
	private String schoolClass;
	private String[] grades;
	private Timetable timetable;

	public Student(String name, int age) {
		super(name, age);
	}

	public String[] getGrades() {
		return grades;
	}

	public void addGrade(String grade) {
		String[] newGrades = new String[grades.length + 1];
		for (int i = 0; i < newGrades.length - 1; i++) {
			newGrades[i] = grades[i];
		}
		newGrades[newGrades.length - 1] = grade;
		this.grades = newGrades;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void updateTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

}
