package cn.jhc.zx.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.zx.dao.StudentMapper;
import cn.jhc.zx.entity.Student;

public class Demo {
	StudentMapper studentMapper;
	SqlSession session;
	
	@Before
	public void before(){
        InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectStudentAndClass(){
		List<Student> list = studentMapper.selectStudentAndClass();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			System.out.println(list.get(i).getClazz());
		}
	}
	
	@Test
	public void testDeleteStudent(){
		studentMapper.deleteStudent(3);
		session.commit();
	}
	
	@Test
	public void testSelectStudentById(){
		System.out.println(studentMapper.selectStudentById(1));
	}
	
	@Test
	public void testUpdateStudent(){
		Student st = new Student();
		st.setId(2);
		st.setAge(1);
		studentMapper.updateStudent(st);
		session.commit();
	}
	
	@Test
	public void testInsertStudent(){
		Student st = new Student("mira",20);
		studentMapper.insertStudent(st);
		session.commit();
		List<Student> list = studentMapper.selectStudentAndClass();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testSelectStudentByClazzId(){
		List<Student> list = studentMapper.selectStudentByClazzId(1);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
