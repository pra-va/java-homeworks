package lt.prava;

public class MainClass {
	public static void main(String[] args) {
		Student studentOne = new Student("Pranas Pranaitis", 14);
		Student studentTwo = new Student("Jonas Jonaitis", 13);
		Student studentThree = new Student("Deivis Dievaitis", 14);
		Student studentFour = new Student("Matas Matulionis", 14);
		Student studentFive = new Student("Povilas Povilaitis", 13);
		Student studentSix = new Student("Baltramiejus Juodaitis", 13);

		SchoolClass classOne = new SchoolClass("7a", studentOne, studentTwo, studentThree, studentFour, studentFive,
				studentSix);

		classOne.printOutSchoolClass();

		Teacher teacherMath = new Teacher("Tomas", 35, new Subject("Math"));
		Teacher teacherLithuanian = new Teacher("Tomas", 35, new Subject("Lithuanian language"));
		Teacher teacherEnglish = new Teacher("Tomas", 35, new Subject("English language"));

		classOne.getTimetable().addTimetableNode(1, 2, teacherMath, classOne);
		classOne.getTimetable().addTimetableNode(1, 2, teacherLithuanian, classOne);
		classOne.getTimetable().removeTimeTableNode(1, 2, teacherMath);
		classOne.getTimetable().addTimetableNode(1, 2, teacherLithuanian, classOne);
		classOne.getTimetable().addTimetableNode(1, 3, teacherLithuanian, classOne);
		classOne.getTimetable().addTimetableNode(2, 1, teacherEnglish, classOne);
		classOne.getTimetable().addTimetableNode(2, 2, teacherEnglish, classOne);
		classOne.getTimetable().addTimetableNode(2, 3, teacherEnglish, classOne);
		classOne.getTimetable().addTimetableNode(3, 1, teacherMath, classOne);
		classOne.getTimetable().addTimetableNode(3, 2, teacherMath, classOne);
		classOne.getTimetable().addTimetableNode(3, 3, teacherMath, classOne);

		System.out.println();
		classOne.getTimetable().print();
		System.out.println();
	}
}
