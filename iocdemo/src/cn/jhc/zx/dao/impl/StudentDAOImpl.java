package cn.jhc.zx.dao.impl;

import java.util.List;

import cn.jhc.zx.dao.StudentDAO;
import cn.jhc.zx.entity.Student;

public class StudentDAOImpl implements StudentDAO{
	
	public List<String> st;
	
	public void setListValue(List<String> listValue) {
		this.st = listValue;
    }

	@Override
	public int save(Student s)
	{
		System.out.println("--save student success--");
		System.out.println(st);
		System.out.println(s);
		return 1;
		
	}
	
	@Override
	public List<Student> query(Student s)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
