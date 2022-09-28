package com.flight.project.servicelayer;

import java.util.List;



import com.flight.project.dto.Flight;



public interface FlightService {
	
	Flight saveFlight(Flight ft);
    
	List<Flight> getAllFlights();
	//get
	Flight getFlightByFlightNumber(long flightNumber);
	
	//update
	Flight updateFlight(Flight flight, long flightNumber);
    //delete
    void deleteFlight(long flightNumber);

	
    
	   

}
