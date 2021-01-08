
public class Entry {

	private String name;
	private Birthday birthday;

	public Entry(String name, Birthday birthday) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.birthday = birthday;
	}

	public Entry(String name, int month, int day) {
		// TODO Auto-generated constructor stub

		this.name = name;
		Birthday b = new Birthday(month, day);
		this.birthday = b;

	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public Birthday getBirthday() {
		// TODO Auto-generated method stub
		return this.birthday;
	}

	public String toString() {
		return this.name + " was born on " + this.birthday;
	}

	public boolean equals(Entry bd) {
		if ((bd.name == this.name) && (this.birthday == bd.birthday))
			return true;
		else if ((this.birthday.getMonth() == bd.birthday.getMonth())
				&& (this.birthday.getDay() == bd.birthday.getDay() && (this.name == bd.name)))
			return true;
		else
			return false;

	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void setBirthday(int month, int day) {
		// TODO Auto-generated method stub
		Birthday b = new Birthday(month, day);
		this.birthday = b;
	}

	public void setBirthday(Birthday bd) {
		// TODO Auto-generated method stub
		this.birthday = bd;
	}

}