package carsharing;

import java.util.ArrayList;

public class Station {
	int stationNumber;
	ArrayList<Passenger> people = new ArrayList<>();

	
	public Station(int number) {
		this.stationNumber = number;
	}
	
	public int getNumber() {
		return this.stationNumber;
	}
	
	public void add(Passenger p) {
		this.people.add(p);
	}
	public Passenger get(int index) {
		return this.people.get(index);
	}
	public Passenger remove(int index) {
		return this.people.remove(index);
	}
	public ArrayList<Passenger> peopleWaitingList(){
		return this.people;
	}
	public String toString() {
		System.out.print(this.peopleWaitingList());
		String s= this.peopleWaitingList().toString();
		return s;
	}
}
