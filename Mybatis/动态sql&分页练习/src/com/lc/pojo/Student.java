package com.lc.pojo;

public class Student {

	private int id;
	private String student_name;
	private int age;
	private String teacher_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeachear_name(String teachear_name) {
		this.teacher_name = teachear_name;
	}
	public Student(int id, String student_name, int age, String teacher_name) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.age = age;
		this.teacher_name = teacher_name;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", student_name=" + student_name + ", age=" + age + ", teachear_name="
				+ teacher_name + "]";
	}
	
	
	
}
