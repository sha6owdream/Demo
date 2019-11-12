package cn.jhc.zx.dao;

import java.util.List;

import cn.jhc.zx.entity.Student;

public interface StudentDAO{
	
	public int save(Student s);
	
	public List<Student> query(Student s);
	
}
