package carsharing;
import java.util.ArrayList;

public class Car {
 private int idNo;
 private int destination;
 private int location;
 private ArrayList<Passenger> passengers = new ArrayList<>();
 private double faresCollected;
 private int milesDriven;
 private double FAREPERMILE = 1.0;
 private int MAXPASSENGERS = 3;
 
 public Car (int idNo,int location,int destination) {
	 this.idNo = idNo;
	 this.location = location;
	 this.destination = destination;
 }
 
 public int getIdNo() {
	 return this.idNo;
 }
 
 public int getLocation() {
	 return this.location;
 }
 
 public int getDestination() {
	 return this.destination;
 }
 
 public double getFares() {
	 return this.faresCollected;
 }
 
 public int getMilesDriven() {
	 return this.milesDriven;
 }
 
 public ArrayList<Passenger> getPassengers(){
	 return this.passengers;
 }
 
 public boolean hasArrived() {
	 if (this.location == this.destination) {
		 return true;
	 }
	 else 
		 return false;
 }
 
 public boolean hasRoom() {
	 if (this.passengers.size() >= this.MAXPASSENGERS) {
		 return false;
	 }
	 else 
		 return true;
 }
 
 public void drive() {
	 if (this.location < this.destination) {
		 this.location += 1;
		 this.faresCollected += this.passengers.size() * this.FAREPERMILE;
	 }
	 System.out.print("Car " + this.getIdNo() + " drives to station " + this.getDestination()+"\n");
	 System.out.print("Car " + this.getIdNo() + " arrives at station " + this.getLocation()+"\n");
 }
 
 public boolean dropOff() {
	 int anydrop = 0;
	 for (int i=0;i<this.getPassengers().size();i++) {
		 if (this.passengers.get(i).getDestination() == this.location) {
			 System.out.print("Car " + this.getIdNo() + " drops off " + this.passengers.get(i) + " at station " + this.getLocation() + " Now has " + (this.passengers.size()-1) + "passengers"+"\n");
			 this.passengers.remove(i);
			 anydrop = 1;
		 }
 }
	 if (anydrop == 1) {
		 return true;
	 }
	 else
		 return false;
}
 
 public boolean add(Passenger p) {
	 if(this.passengers.size() < this.MAXPASSENGERS) {
		 this.passengers.add(p);
		 return true;
	 }
	 else
		 return false;
 }
public String toString() {
	System.out.print("Car " + this.getIdNo() + ", Current at " + this.getLocation() + " Going to " + this.getDestination() + " with Passengers: " + this.getPassengers()+"\n");
	return "Car " + this.getIdNo() + ", Current at " + this.getLocation() + " Going to " + this.getDestination() + " with Passengers: " + this.getPassengers()+"\n";
}
}