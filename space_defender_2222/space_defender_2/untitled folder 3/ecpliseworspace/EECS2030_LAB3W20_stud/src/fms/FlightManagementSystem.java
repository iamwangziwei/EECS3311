package fms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FlightManagementSystem {

	/*
	 * Each entry in a 'passengers' map contains a unique ID (this is different from
	 * the flightID defined in the passenger class), and its associated information
	 * object.
	 */
	HashMap<String, PassengerInfo> passengers;

	/*
	 * Each entry in a 'flights' map contains a unique id (this is different from
	 * the flightID defined in the passenger class) and its associated information
	 * object.
	 */
	HashMap<Integer, FlightInfo> flights;

	/**
	 * Initialize an empty database.
	 */
	public FlightManagementSystem() {
		passengers = new HashMap<String, PassengerInfo>();
		flights = new HashMap<Integer, FlightInfo>();
	}

	/**
	 * Add a new passenger entry.
	 * 
	 * @param id   - id of the passenger
	 * @param info - information object of the passenger
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing passenger id
	 */
	public void addPassenger(String id, PassengerInfo info) throws IdAlreadyExistsExceptoin {
		if (!passengers.containsKey(id)) {
			passengers.put(id, info);
		} else
			throw new IdAlreadyExistsExceptoin("Id Already Exists");

	}

	/**
	 * Remove an existing passenger entry.
	 * 
	 * @param id - id of the passenger
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public void removePassenger(String id) throws IdNotFoundException {
		if (!passengers.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		}
		passengers.remove(id);
	}

	/**
	 * Add a new flight entry.
	 * 
	 * @param id   id of the flight
	 * @param info information object of the flight
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing flight id
	 */
	public void addFlight(Integer id, FlightInfo info) throws IdAlreadyExistsExceptoin {
		if (!flights.containsKey(id)) {
			flights.put(id, info);
		} else
			throw new IdAlreadyExistsExceptoin("Id Already Exists");

	}

	/**
	 * Remove an existing flight entry.
	 * 
	 * @param id id of some flight
	 * @throws IdNotFoundException if 'id' is not an existing flight
	 */
	public void removeFlight(Integer id) throws IdNotFoundException {
		if (!flights.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		}
		flights.remove(id);
	}

	/**
	 * Change the flight of passenger with id 'eid' to a new flight with id 'did'.
	 * 
	 * You can assume that 'did' denotes a flight different from the current flight
	 * of the passenger denoted by 'eid'.
	 * 
	 * @param eid id of some passenger
	 * @param did id of some flight
	 * @throws IdNotFoundException if either eid is a non-existing passenger id or
	 *                             did is a non-existing flight id.
	 */
	public void changeFlight(String eid, Integer did) throws IdNotFoundException {
		if (!passengers.containsKey(eid)) {
			throw new IdNotFoundException("Id Not Found");
		}
		if (!flights.containsKey(did)) {
			throw new IdNotFoundException("Id Not Found");
		}
		passengers.get(eid).setFlightId(did);
	}

	/**
	 * Retrieve the name of passenger with id 'id'.
	 * 
	 * @param id id of some passenger
	 * @return name of the passenger with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public String getPassengerName(String id) throws IdNotFoundException {
		if (!passengers.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		}
		return passengers.get(id).getName();
	}

	/**
	 * Retrieve the names of all passengers of the flight with id 'id'. If 'id' a
	 * non-existing flight id, then return an empty list.
	 * 
	 * @param id id of some flight
	 * @return List of names of passengers whose flight has id 'id'
	 */
	public ArrayList<String> getPassengerNames(Integer id) {
		if (!flights.containsKey(id)) {
			return new ArrayList<>();
		}
		ArrayList<String> result = new ArrayList<>();
		for (PassengerInfo p : passengers.values()) {
			if (p.getFlightId() == id) {
				result.add(p.getName());
			}
		}
		return result;
	}

	/**
	 * Retrieve passengers flight information object.
	 * 
	 * @param id id of some passenger
	 * @return The information object of the passengers flight
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public FlightInfo getFlightInfo(String id) throws IdNotFoundException {
		if (!passengers.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		}
		return flights.get(passengers.get(id).getFlightId());
	}

	/**
	 * Retrieve a list, sorted in increasing order, the information objects of all
	 * stored passengers.
	 * 
	 * Hints: 1. Override the 'compareTo' method in PassengerInfo class. 2. Look up
	 * the Arrays.sort method in Java API.
	 * 
	 * @return A sorted list of information objects of all passengers.
	 */
	public PassengerInfo[] getSortedPassengerInfo() {
		PassengerInfo[] array = passengers.values().toArray(new PassengerInfo[0]);
		Arrays.sort(array);
		return array;
	}

	/**
	 * Retrieve the average ticket paid by all passengers in flight with id 'id'.
	 * 
	 * @param id id of some flight
	 * @return average ticket paid by all passengers in a flight with id 'id'
	 * @throws IdNotFoundException if id is not an existing flight id
	 */
	public double getAverageTicketAmount(Integer id) throws IdNotFoundException {
		if (!flights.containsKey(id)) {
			throw new IdNotFoundException("Id Not Found");
		}
		double sum = 0;
		int count = 0;
		for (PassengerInfo passengerInfo : passengers.values()) {
			if (passengerInfo.getFlightId() == id) {
				sum = sum + passengerInfo.getTicketAmount();
				count++;
			}
		}
		if (count > 0) {
			sum = sum / count;
		}
		return sum;
	}
}