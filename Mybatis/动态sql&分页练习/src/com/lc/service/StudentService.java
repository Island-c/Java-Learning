package com.lc.service;

import java.io.IOException;
import java.util.List;

import com.lc.pojo.PageInfo;
import com.lc.pojo.Student;

public interface StudentService {

	PageInfo showPage(int pageNumber, int pageSize,String student_name,String teacher_name) throws IOException;
}
