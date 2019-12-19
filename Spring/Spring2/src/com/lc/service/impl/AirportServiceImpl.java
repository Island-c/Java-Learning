package com.lc.service.impl;

import java.util.List;

import com.lc.mapper.AirportMapper;
import com.lc.pojo.Airport;
import com.lc.service.AirportService;

public class AirportServiceImpl implements AirportService{

	private AirportMapper airportMapper;
	
	public AirportMapper getAirportMapper() {
		return airportMapper;
	}

	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}

	@Override
	public List<Airport> show() {
		return airportMapper.selAll();
	}
	

}
