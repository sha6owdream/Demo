package cn.jhc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.zx.dao.ClazzMapper;
import cn.jhc.zx.entity.Clazz;
import cn.jhc.zx.entity.Student;

public class ClazzDemo {
	ClazzMapper clazzMapper;
	SqlSession session;
	
	@Before
	public void before(){
        InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
			session = sessionFactory.openSession();
			clazzMapper = session.getMapper(ClazzMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSelect(){
		List<Clazz> list = clazzMapper.select();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			System.out.println(list.get(i).getStudents());
		}
	}
	
	@Test
	public void testSelectByStudentId(){
		Clazz c = clazzMapper.selectByStudentId(1);
		System.out.println(c);
	}
}
