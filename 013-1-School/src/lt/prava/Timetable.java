package lt.prava;

public class Timetable {
	private Subject[][] subjects; // [Week day] [Subject]

	public Timetable() {
		this.subjects = new Subject[5][7];
		for (int i = 0; i < subjects.length; i++) {
			for (int j = 0; j < 7; j++) {
				subjects[i][j] = new Subject("Empty");
			}
		}
	}

	/**
	 * Method to add a subject for students to their timetable. Teacher has to be
	 * specified because this teacher must have free lesson at provided time.
	 * 
	 * @param day
	 * @param lesson
	 * @param subject
	 * @param teacher
	 */
	public void addTimetableNode(int day, int lesson, Teacher teacher, SchoolClass schoolClass) {
		if (teacher.getTimetable()[day - 1][lesson - 1] == null
				&& this.subjects[day - 1][lesson - 1].getName().equals("Empty")) {
			this.subjects[day - 1][lesson - 1] = teacher.getPrimarySubject();
			teacher.getTimetable()[day - 1][lesson - 1] = schoolClass;
			System.out.println("Teacher " + teacher.getName() + " and class " + schoolClass.getClassName()
					+ " has new timetable node on week day " + day + ", lesson " + lesson + ".");
		} else {
			System.out.println("Unable to add " + teacher.getPrimarySubject().getName()
					+ " to timetable. Either students or teacher is busy.");
		}
	}

	public void removeTimeTableNode(int day, int lesson, Teacher teacher) {
		teacher.getTimetable()[day - 1][lesson - 1] = null;
		this.subjects[day - 1][lesson - 1] = new Subject("Empty");
		System.out.println("Removing subject on week day " + day + " lesson " + lesson + ".");
	}

	public Subject[][] getSubjects() {
		return subjects;
	}

	public void print() {
		System.out.printf("%2s %20s %20s %20s %20s %20s", " ", "Pirmadienis", "Antradienis", "Treciadienis",
				"Ketvirtadienis", "Penktadienis");
		for (int i = 0; i < 7; i++) {
			System.out.printf("\n%2s %20s %20s %20s %20s %20s", i + 1, subjects[0][i].getName(),
					subjects[1][i].getName(), subjects[2][i].getName(), subjects[3][i].getName(),
					subjects[4][i].getName());
		}
	}

}
