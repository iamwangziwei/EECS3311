package studentSystem;

public class Course {
	
	private int code;  // non private for testing purposes
	private String name;
	private String instructor;
	
	/**
	 * @param code  code of the course
	 * @param name  name of the course
	 * @param instructor instructor of the course
	 */
	public Course(int code, String name, String instructor) {
		super();
		this.code = code;
		this.name = name;
		this.instructor = instructor;
	}
	
	/**
	 * @return the code
	 */
	 
	public int getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	/*@Override
	public String toString() {
		return "Course [code=" + code + ", name=" + name + ", instructor=" + instructor + "]";
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	/**
	 * two Course are equal if they have the same code, name and instructor.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		if (code != other.code) {
			return false;
		}
		if (instructor == null) {
			if (other.instructor != null) {
				return false;
			}
		} else if (!instructor.equals(other.instructor)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	
	

}
