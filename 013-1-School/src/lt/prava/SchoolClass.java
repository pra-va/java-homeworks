package lt.prava;

/**
 * School class is used to store and manipulate students that are in this class,
 * their timetable, and class name.
 * 
 * @author pra-va
 *
 */
public class SchoolClass {
	private Student[] students;
	private String className;
	private Timetable timetable;

	public SchoolClass(String className, Student... students) {
		if (students.length > 0) {
			this.students = students;
		} else {
			System.out.println("Creating empty class.");
		}
		this.timetable = new Timetable();
		this.className = className;
	}

	public Student[] getStudents() {
		return students;
	}

	public String getClassName() {
		return className;
	}

	public void printOutSchoolClass() {
		if (students.length > 0) {
			System.out.println("Printing student class " + this.className);
			for (int i = 0; i < students.length; i++) {
				System.out.println(this.students[i].getName() + ", " + this.students[i].getAge());
			}
		} else {
			System.out.println("Class " + className + " is empty.");
		}
	}

	public Timetable getTimetable() {
		return timetable;
	}

}
