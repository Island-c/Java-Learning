package com.lc.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.lc.mapper.StudentMapper;
import com.lc.pojo.PageInfo;
import com.lc.pojo.Student;
import com.lc.service.StudentService;
import com.lc.utils.MyBatisUtils;

public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo showPage(int pageNumber, int pageSize,String student_name,String teacher_name) throws IOException {
		Logger logger =Logger.getLogger(this.getClass());
		
		SqlSession session =MyBatisUtils.getSession();
		
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		
		int pageStart = pageSize*(pageNumber-1);
		List<Student> list = mapper .selPage(pageStart, pageSize,student_name,teacher_name);
		int count = mapper.selCount(student_name,teacher_name);//总的条目
		
		count = count%pageSize==0 ? count/pageSize : count/pageSize+1 ;
		
		
		logger.info("count: " + count);
		
		PageInfo pi = new PageInfo(pageNumber,pageSize,count,student_name,teacher_name,list);
		
		
		return pi;
	}
	
	
	
	public static void main(String[] args) {
		StudentServiceImpl ss = new StudentServiceImpl();
		try {
			PageInfo  pi = ss.showPage(1, 2,"","李老师");
			System.out.println(pi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("???");
		}
	}

}
