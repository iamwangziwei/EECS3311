
public class BirthdayBook {
	private final int  max = 10;
	private Entry[] entry;
	private int num;
	private int name;
	
	public BirthdayBook() {
		this.entry = new Entry[max];
		this.num=0;
	}
	public Object getNumberOfEntries() {
		// TODO Auto-generated method stub
		return this.num;
	}

	public Entry[] getEntries() {
		// TODO Auto-generated method stub
		Entry[] es = new Entry[num];
		for (int i = 0;i < num;i++) {
			Entry e = entry[i];
			es[i] =e;
		}
		return es;
	}
	
	public String toString() {
		String s ="";
		
		for (int i=0;i<num;i++) {
			String name = entry[i].getName();
			Birthday b = entry[i].getBirthday();
			s=s+name+" was born on "+b+"\n";}
		return "There are "+this.getNumberOfEntries()+" entries in the book\n"+s;
	}
	
	private int index(String name) {
		int index = -1;
		boolean f = false;
		for (int i=0;i<num && !f;i++) {
			Entry e = this.entry[i];
			String n = e.getName();
			if (name.equals(n) ) {
				index =i;
				f =true;}
			else
				index= -1;
		}
		return index;
	}
	
	public boolean nameExists(String name) {
		// TODO Auto-generated method stub
		int index = index(name);
		return index >=0;
		
	}
	public Birthday getBirthday(String name) {
		// TODO Auto-generated method stub
		int in = index(name);
		return entry[in].getBirthday();
	}
	
	
	public String[] getReminders(Birthday bd) {
		// TODO Auto-generated method stub
		int count = 0;
		
		boolean f = false;
		
		
		for (int i=0;i<num && !f;i++) {
			Entry e = this.entry[i];
			Birthday n = e.getBirthday();
			if (bd.equals(n) ) {
				
				count++;
				
			}
			
		}
		
		String[] s = new String[count];
		s[count]=e.getName();
		
		
		return s;
	}
	public String[] getReminders(int month, int day) {
		// TODO Auto-generated method stub
		
		
		Birthday b = new Birthday(month,day);
		String[] s= getReminders(b);
		return s;
	}
	
	public void removeEntry(String name) {
		// TODO Auto-generated method stub
		
		for(int i =0;i<this.num;i++) {
			if(entry[i].getName()==name) {
				this.num--;
				for(int j =i+1;j<this.num;j++) {
					entry[i] = entry[j];
				}
			}
		}
	
	}
	
	public void addEntry(String name, Birthday bd) {
		// TODO Auto-generated method stub
		Entry e = new Entry(name,bd);
		
		entry[this.num]=e;
		e.setBirthday(bd);
		e.setName(name);
		this.num++;
	}
	public void addEntry(String name, int month,int day) {
		// TODO Auto-generated method stub
		Birthday b = new Birthday(month,day);
		this.addEntry(name, b);
		
	}
	
	
	


	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
