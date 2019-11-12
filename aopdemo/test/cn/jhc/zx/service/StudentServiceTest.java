package cn.jhc.zx.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest
{

	@Test
	public void test()
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("studentbean.xml");
		StudentService service=(StudentService) applicationContext.getBean("studentService");
		service.save();
	}

}
