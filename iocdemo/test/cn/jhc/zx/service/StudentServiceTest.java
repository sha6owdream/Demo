package cn.jhc.zx.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.zx.entity.Student;
import cn.jhc.zx.service.StudentService;


public class StudentServiceTest{
	
	StudentService service;
	Student student;
	Student student2;
	BeanFactory applicationContext;
	
	@Before
	public void init() {

		applicationContext=new ClassPathXmlApplicationContext("bean.xml");
		service=(StudentService) applicationContext.getBean("studentservice");
		student=(Student) applicationContext.getBean("student");
		student2=(Student) applicationContext.getBean("student");
	}
	
	//set注入和构造方法注入测试方法
	@Test
	public void testSave()
	{
		service.save(student);
	}
	
	//单例多例模式测试方法，当前为单例模式，
	//更改为多例要把bean.xml中的单例模式注释掉，多例模式注释解开
	@Test
	public void testSave2()
	{
		student.setSno(789);
		System.out.println(student);
		System.out.println(student2);
	}
	
	//bean生命周期测试方法
	@Test
	public void testSave3() {
		System.out.println(student);
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
	
}
