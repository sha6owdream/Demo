package cn.jhc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
	public void testSelect(){
		List<Student> list = studentMapper.select();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			System.out.println(list.get(i).getClazz());
		}
	}
	
	@Test
	public void testDeleteStudent(){
		studentMapper.deleteStudent(5);
		session.commit();
	}
	
	@Test
	public void testGetStudent(){
		Student s = studentMapper.getStudent(1);
		System.out.println(s);
	}
	
	@Test
	public void testUpdateStudent(){
		Student st = new Student();
		st.setAge(10);
		st.setId(2);
		studentMapper.updateStudent(st);
		session.commit();
	}
	
	@Test
	public void testInsertStudent(){
		Student st = new Student("mira",30);
		studentMapper.insertStudent(st);
		session.commit();
		System.out.println(st);
	}
	@Test
	public void testFindStudentByName(){
		Student s = new Student();
		s.setName("%i%");
		s.setAge(20);
		List<Student> list = studentMapper.findStudentByName(s);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testFindStudentByIds(){
		List<Integer> ids  = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		List<Student> list = studentMapper.findStudentByIds(ids);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testFindChooseBind(){
		Student s = new Student();
		List<Student> list = studentMapper.findChooseBind(s);
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
