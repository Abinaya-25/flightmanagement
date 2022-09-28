package com.flight.project.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.project.dto.Flight;
import com.flight.project.servicelayer.FlightService;
@RestController
@RequestMapping("/api/flightdetails")

public class FlightController {
	
	    //DI
	    private FlightService flightser;
	    //constructor
	public FlightController(FlightService flightser) {
		super();
		this.flightser = flightser;
	}
	@PostMapping
	    public ResponseEntity<Flight> saveFlight(@RequestBody Flight ft){
	        return new ResponseEntity<Flight>
	        (flightser.saveFlight(ft),HttpStatus.CREATED);
	        }
	@GetMapping
	public List<Flight> getAllFlight(){
	    return flightser.getAllFlights();
	}
	@GetMapping("{flightNumber}")
	public ResponseEntity<Flight> getFlightByNumber(@PathVariable("flightNumber") long flightNumber){
		return new ResponseEntity<Flight>(flightser.getFlightByFlightNumber(flightNumber),
        HttpStatus.OK);
	}
	//build update flight Rest API
    @PutMapping("{flightNumber}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("flightNumber")long flightNumber ,
            @RequestBody Flight flight){
                return new ResponseEntity<Flight>(flightser.updateFlight(flight, flightNumber),
                    HttpStatus.OK);
    }
    
    //build delete flight
    @DeleteMapping("{flightNumber}")
    public ResponseEntity<String> deleteFlight(@PathVariable("flightNumber")long flightNumber){
        //delete 
        flightser.deleteFlight(flightNumber);
        return new ResponseEntity<String>("Flight deleted successfully.!",HttpStatus.OK);
        
    }
	
		
	    

	 

	

}
