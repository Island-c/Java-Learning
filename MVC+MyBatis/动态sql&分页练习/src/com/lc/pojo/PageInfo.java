package com.lc.pojo;

import java.util.List;

public class PageInfo {
	private int pageNumber;
	private int pageSize;
	private int count;
	private String student_name;
	private String teacher_name;
	
	
	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	List<Student> list; //该页显示的学生



	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int pageNumber, int pageSize, int count, String student_name, String teacher_name,
			List<Student> list) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.count = count;
		this.student_name = student_name;
		this.teacher_name = teacher_name;
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", count=" + count + ", student_name="
				+ student_name + ", teacher_name=" + teacher_name + ", list=" + list + "]";
	}







	
	
}
