package com.lc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lc.pojo.Log;
import com.lc.pojo.PageInfo;
import com.lc.service.LogService;

public class LogServiceImpl implements LogService{

	/**
	 * 分页
	 */
	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		
		InputStream is =Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		PageInfo pi =new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		
		Map<String,Object> map = new HashMap<>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Log> list = session.selectList("com.lc.mapper.LogMapper.selByPage",map);
		long count= session.selectOne("com.lc.mapper.LogMapper.selCount");
		
		pi.setList(list);
		pi.setTotal(count%pageSize ==0 ? count/pageSize : count/pageSize+1);
		
		return pi;
	}

}
