package fms;

public class FlightInfo {
	private String name;
	private String airline;

	public FlightInfo(String name, String airline) {
		this.name = name;
		this.airline = airline;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FlightInfo) {
			FlightInfo other = (FlightInfo) obj;
			return name.equals(other.name) && airline.equals(other.airline);
		} else {
			return false;
		}
	}

	public String getairline() {
		return airline;
	}

	public String getName() {
		return name;
	}

	public void setairline(String airline) {
		this.airline = airline;
	}

	public void setName(String name) {
		this.name = name;
	}

}
