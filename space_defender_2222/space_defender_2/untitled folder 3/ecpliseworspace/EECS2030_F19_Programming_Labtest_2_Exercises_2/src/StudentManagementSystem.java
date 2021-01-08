public class StudentManagementSystem {

	Student[] student;
	int num;
	
	public StudentManagementSystem() {
		student = new Student[30];
	}
	
	
	/* Since ResidentStudnet extends Student, and
	 * NonResidentStudent extends Student,
	 * we may consider their parent class (Student)
	 * as their "representative". 
	 */
	// This array can store any objects whose types
	// are sub/child classes of Student (i.e., RS and NRS).

	public void addStudent(Student name) {
		// TODO Auto-generated method stub
		student[num] = name;
		num++;
	}

	public void registerAll(Course cname) {
		// TODO Auto-generated method stub
		for(int i =0;i<num;i++) {
			student[i].register(cname);
		}
	}


	public Student[] getStudents() {
		// TODO Auto-generated method stub
		Student[] n = new Student[num];
		for(int i =0;i<num;i++)
			n[i] = student[i];
		return n;
	}
	
	
}




