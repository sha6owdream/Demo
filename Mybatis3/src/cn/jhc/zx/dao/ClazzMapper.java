package cn.jhc.zx.dao;

import java.util.List;

import cn.jhc.zx.entity.Clazz;


public interface ClazzMapper {
	
	public List<Clazz> select();
	
	public Clazz selectByStudentId(int id);
	
}
