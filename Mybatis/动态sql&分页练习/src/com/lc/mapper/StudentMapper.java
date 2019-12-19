package com.lc.mapper;

import java.util.List;

import com.lc.pojo.Student;

public interface StudentMapper {

	
	List<Student> selPage(int pageNumber,int pageSize,String student_name,String teacher_name);
	
	int selCount(String student_name,String teacher_name);
	
}
