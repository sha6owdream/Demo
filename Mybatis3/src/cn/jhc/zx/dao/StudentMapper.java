package cn.jhc.zx.dao;

import java.util.List;

import cn.jhc.zx.entity.Clazz;
import cn.jhc.zx.entity.Student;

public interface StudentMapper {
	
	public List<Student> select();
	
	public Student getStudent(int id);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student student);
	
	public void insertStudent(Student student);
	
	public List<Student> findStudentByName(Student student);
	
	public List<Student> findStudentByIds(List<Integer> ids);
	
	public List<Student> findChooseBind(Student student);
	
	public List<Student> selectStudentByClazzId(int id);
	
}
