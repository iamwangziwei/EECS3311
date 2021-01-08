package studentSystem;

public class Course {

	private int code;
	private String cname, prof;

	public Course(int code, String cname, String prof) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.cname = cname;
		this.prof = prof;
	}


	public int hashCode()
	{
		final int prime =31;
		int result =1;
		result = prime*result + code;
		result = prime*result +((prof==null) ? 0 : prof.hashCode());
		result = prime * result + ((cname==null) ? 0 : cname.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		
		if(this.getClass() !=obj.getClass() || obj==null)
			return false;
		if(this==obj)
			return true;
		Course c= (Course)obj;
		
		if(this.cname.equals(c.cname) && this.code == c.code && this.prof.equals(c.prof))
			return true;
		return false;
	/*	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (code != other.code)
			return false;
		if (prof == null) {
			if (other.prof != null)
				return false;
		} else if (!prof.equals(other.prof))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		return true;*/
	}

	public int getCode() {
		// TODO Auto-generated method stub
		return this.code;
	}
	public String getcname() {
		// TODO Auto-generated method stub
		return this.cname;
	}
	public String getprof() {
		return this.prof;
	}

	public void setInstructor(String prof) {
		// TODO Auto-generated method stub
		this.prof = prof;
	}
}



























