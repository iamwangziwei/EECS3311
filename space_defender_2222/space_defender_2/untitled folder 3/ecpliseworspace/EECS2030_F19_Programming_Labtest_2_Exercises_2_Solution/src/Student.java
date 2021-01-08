
/*
 * We define what is common between ResidentStudent and
 * NonResidentStudent in this single place.
 */

public class Student {
	String name;
	Course[] registeredCourses;
	int noc; /* number of courses */
	
	/* premimumRate or discountRate does not belong
	 * to this class. */
	
	Student(String name) {
		this.name = name;
		registeredCourses = new Course[30];
	}
	
	void register(Course c) {
		/* Place #1 to have a new course policy. */
		if(noc >= 5) {
			/* Error */
		}
		else {
			registeredCourses[noc] = c;
			noc ++;
		}
	}
	
	Course[] getCourses() {
		Course[] courses = new Course[this.noc];
		for(int i = 0; i < noc; i ++) {
			courses[i] = registeredCourses[i];
		}
		return courses;
	}
	
	void drop(Course c) {
		int index = indexOf(c.getTitle());
		if(index < 0) {
			// name does not exist,
			// nothing to remove
		}
		else {
			// remove the associated entry for name
			/* Step 1: From positions index to (noc - 2), shift
			 * every entry to the left by one position.
			 */
			for(int i = index; i < noc - 1; i ++) {
				this.registeredCourses[i] = this.registeredCourses[i + 1];
			}
			/*
			 * Step 2: Assign position entries[noc - 1] to null.
			 */
			this.registeredCourses[noc - 1] = null;
			/*
			 * Step 3: Decrement noc.
			 */
			this.noc --;
		}
	}
	
	private int indexOf(String n) {
		int index = -1;
		
		/* common mistake: i < entries.length */
		boolean found = false;
		for(int i = 0; i < noc && !found; i ++) {
			Course e = registeredCourses[i];
			if(e.getTitle().equals(n)) {
				index = i;
				found = true;
			}
		}
		return index;
	}
	
	double getTuition() {
		double base = 0;
		
		for(int i = 0; i < noc; i ++) {
			base += registeredCourses[i].getFee();
		}
		
		return base;
	}
}
