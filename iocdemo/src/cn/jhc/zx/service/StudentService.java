package cn.jhc.zx.service;

import cn.jhc.zx.dao.StudentDAO;
import cn.jhc.zx.entity.Student;

public class StudentService{

	private StudentDAO dao;
	
	
	public StudentService(StudentDAO studentDAO) {
		this.dao=studentDAO;
	}
	
	
	public StudentService()
	{
		
	}
	
	private void setStudentDAO(StudentDAO studentDAO)
	{
		this.dao=studentDAO;
	}
	
	public void save(Student s) {
		dao.save(s);
	}
	
}
