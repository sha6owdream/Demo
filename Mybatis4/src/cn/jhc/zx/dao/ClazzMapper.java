package cn.jhc.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import cn.jhc.zx.entity.Clazz;


public interface ClazzMapper {
	
//	查询所有的班级和学生
	@Select("select * from clazz ")
	@Results(value={
			@Result(property="clazz",column="clazz"),
			@Result(property="clazzName",column="c_name"),
			@Result(property="students",column="clazz",
			many=@Many(select="cn.jhc.zx.dao.StudentMapper.selectStudentAndClass",fetchType= FetchType.LAZY))
	})
	public List<Clazz> select();
	
//	通过学生编号，查询该学生所在班级
	@Select("select * from clazz where clazz = #{clazz}")
	@Results(value={
			@Result(property="clazz",column="clazz"),
			@Result(property="clazzName",column="c_name"),
	})
	public Clazz selectByStudentId(int id);
}
