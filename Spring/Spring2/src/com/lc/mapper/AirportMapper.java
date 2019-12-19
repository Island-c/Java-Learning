package com.lc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lc.pojo.Airport;

public interface AirportMapper {

	@Select("select * from airport")
	List<Airport> selAll();
}
