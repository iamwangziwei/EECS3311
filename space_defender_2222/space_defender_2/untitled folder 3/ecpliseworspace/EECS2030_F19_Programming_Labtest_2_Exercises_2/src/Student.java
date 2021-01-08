

public class Student {
	
	int num;
	private String name = "";
	Course[] course ;
	 
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		course = new Course[30];
	}

	void register(Course c) {
		/* Place #1 to have a new course policy. */
		
			course[num] = c;
			num ++;
		
	}
	
	public double getTuition() {
		// TODO Auto-generated method stub
		
		double base = 0;
		for(int i =0;i<num;i++) {
			base += course[i].getFee();
			}
		return base;
	}

	public Course[] getCourses() {
		// TODO Auto-generated method stub
		Course[] c = new Course[num];
		for(int i =0;i<num;i++) {
			c[i] = course[i];
		}
		return c;
	}

	public void drop(Course c) {
		// TODO Auto-generated method stub
		for(int i =0;i<num;i++) {
			if(course[i] != c) {
				continue;
			}
			else {
				for(int k =i+1;k<num;k++)
					course[i]=course[k];
			}
		}
		num--;
	}

	



	
}
