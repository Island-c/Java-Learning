package com.lc.service;

import java.util.List;

import com.lc.pojo.Flower;

public interface FlowerService {
	
	/**
	 * 显示所有花的信息
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * 新增
	 * @return
	 */
	int add(Flower flower);
}
