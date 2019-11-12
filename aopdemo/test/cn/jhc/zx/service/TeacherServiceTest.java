package cn.jhc.zx.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherServiceTest
{

	@Test
	public void test()
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("teacherbean.xml");
		TeacherService service=(TeacherService) applicationContext.getBean("teacherService");
		service.save();
	}

}
