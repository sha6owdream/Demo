package cn.jhc.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.jhc.zx.entity.Student;

public interface StudentMapper {
	
//	查询所有学生和班级
	@Select("select * from student")
	@Results(id="studentMap",
		value={
			@Result(id=true,property="id",column="s_id"),
			@Result(property="name",column="s_name"),
			@Result(property="age",column="age"),
			@Result(property="clazz",column="clazz",
			one=@One(select="cn.jhc.zx.dao.ClazzMapper.selectByStudentId")),
	})
	public List<Student> selectStudentAndClass();
	
//	通过学生编号查询学生信息
	@Select("select * from student where s_id=#{id}")
	@ResultMap("studentMap")
	public Student selectStudentById(int id);
	
//	通过学生编号删除学生信息
	@Delete("delete from student where s_id=#{id}")
	public void deleteStudent(int id);
	
//	通过学生编号更新学生姓名或年龄
	@Update("<script>update student <trim prefix='set' suffixOverrides=','><if test='name!=null'>s_name=#{name},</if><if test='age!=0'>age=#{age},</if></trim><where>s_id=#{id}</where></script>")
	public void updateStudent(Student student);
	
//	插入一条学生信息
	@Insert("insert into student (s_name,age) values (#{name},#{age})")
	public void insertStudent(Student student);
	
//	根据班级编号查询班级内所有学生
	@Select("select * from student where clazz = #{id}")
	@ResultMap("studentMap")
	public List<Student> selectStudentByClazzId(int id);
}
