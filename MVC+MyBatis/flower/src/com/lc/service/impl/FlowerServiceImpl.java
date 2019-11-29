package com.lc.service.impl;

import java.util.List;

import com.lc.dao.FlowerDao;
import com.lc.dao.impl.FlowerDaoImpl;
import com.lc.pojo.Flower;
import com.lc.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	private FlowerDao flowerdao =  new FlowerDaoImpl();
	
	@Override
	public List<Flower> show() {
		
		return flowerdao.selAll();
	}

	@Override
	public int add(Flower flower) {
		
		return flowerdao.insFlower(flower);
	}

}
