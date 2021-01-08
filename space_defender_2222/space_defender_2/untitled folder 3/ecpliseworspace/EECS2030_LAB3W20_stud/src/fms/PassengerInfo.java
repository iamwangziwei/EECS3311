package fms;

public class PassengerInfo implements Comparable<PassengerInfo> {
	private String name;
	private double ticketAmount;
	private int flightID;

	public PassengerInfo(String name, double ticketAmount, int flightID) {
		this.name = name;
		this.ticketAmount = ticketAmount;
		this.flightID = flightID;
	}

	public int compareTo(PassengerInfo other) {
		if (this.ticketAmount > other.ticketAmount) {
			return 1;
		} else if (this.ticketAmount == other.ticketAmount) {
			if (this.flightID > other.flightID) {
				return -1;
			} else if (this.flightID == other.flightID) {
				return 0;
			}
		}
		return -1;
	}

	public boolean equals(Object obj) {
		if (obj instanceof PassengerInfo) {
			PassengerInfo other = (PassengerInfo) obj;
			return name.equals(other.name) && ticketAmount == other.ticketAmount && flightID == other.flightID;
		} else {
			return false;
		}
	}

	public int getFlightId() {
		return flightID;
	}

	public String getName() {
		return name;
	}

	public double getTicketAmount() {
		return ticketAmount;
	}

	public void setFlightId(int flightID) {
		this.flightID = flightID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
}
