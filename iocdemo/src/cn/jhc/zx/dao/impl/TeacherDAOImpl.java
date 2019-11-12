package cn.jhc.zx.dao.impl;

import org.springframework.stereotype.Component;

import cn.jhc.zx.dao.TeacherDAO;
import cn.jhc.zx.entity.Teacher;

@Component("teacherDAO")
public class TeacherDAOImpl implements TeacherDAO
{

	@Override
	public int save(Teacher t)
	{
		System.out.println("--save teacher success--");
		return 1;
	}

	
	
}
