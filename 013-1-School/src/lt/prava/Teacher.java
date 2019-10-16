package lt.prava;

/**
 * Teacher class. It extends human class that has two fields: name and age.
 * Teacher object must have primary subject that he teaches. He also may have
 * secondary subject that he can teach which can be set using setter method.
 * 
 * @author pra-va
 *
 */
public class Teacher extends Human {

	private Subject primarySubject;
	private Student[] students;
	private SchoolClass[][] timetable;

	public Teacher(String name, int age, Subject primarySubject) {
		super(name, age);
		this.primarySubject = primarySubject;
		this.timetable = new SchoolClass[5][7];
	}

	public Subject getPrimarySubject() {
		return primarySubject;
	}

	public SchoolClass[][] getTimetable() {
		return timetable;
	}
}
