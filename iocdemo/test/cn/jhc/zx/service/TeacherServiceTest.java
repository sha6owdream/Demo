package cn.jhc.zx.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.zx.entity.Student;
import cn.jhc.zx.entity.Teacher;

public class TeacherServiceTest
{
	TeacherService service;
	Teacher teacher;
	Teacher teacher2;
	BeanFactory applicationContext;
	
	@Before
	public void init() {

		applicationContext=new ClassPathXmlApplicationContext("teacherbean.xml");
		service=(TeacherService) applicationContext.getBean("teacherService");
		teacher=(Teacher) applicationContext.getBean("teacher");
		teacher2=(Teacher) applicationContext.getBean("teacher");
	}

	@Test
	public void testSave() {
		service.save(teacher);
		System.out.println(teacher == teacher2);
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
