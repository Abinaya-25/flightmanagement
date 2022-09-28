package com.flight.project.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.project.dao.FlightDaoImpl;
import com.flight.project.dto.Flight;
import com.flight.project.exception.ResourceNotFound;

@Service
public class FlightServiceImpl implements  FlightService{
	//Dependency injection
	@Autowired
	private FlightDaoImpl flightdao;
	//Constuctor injection
	public FlightServiceImpl(FlightDaoImpl flightdao) {
        super();
        this.flightdao = flightdao;
	}
	@Override
    public Flight saveFlight(Flight flight) {
        return flightdao.save(flight);
    }
	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightdao.findAll();
	}
	@Override
	public Flight getFlightByFlightNumber(long flightNumber) {
		// TODO Auto-generated method stub
		return flightdao.findById(flightNumber).orElseThrow(()-> 
		new ResourceNotFound("Flight","Number",flightNumber));
		
	}
	@Override
	public Flight updateFlight(Flight flight, long flightNumber) {
		Flight existingFlight=flightdao.findById(flightNumber).orElseThrow(()->
		new ResourceNotFound("Flight","ID",flightNumber));
		
		//existingFlight.setFlightNumber(flight.getFlightNumber());
		existingFlight.setFlightModel(flight.getFlightModel());
		existingFlight.setCarrierName(flight.getCarrierName());
		existingFlight.setSeatCapacity(flight.getSeatCapacity());
		
		flightdao.save(existingFlight);
		return  existingFlight;
	}
	@Override
	public void deleteFlight(long flightNumber) {
		flightdao.findById(flightNumber).orElseThrow(()->
		new ResourceNotFound("Flight","Id",flightNumber));
		flightdao.deleteById(flightNumber);
		
		
		
	}



  
    



}