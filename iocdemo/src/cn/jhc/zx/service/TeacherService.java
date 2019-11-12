package cn.jhc.zx.service;

import org.springframework.stereotype.Component;

import cn.jhc.zx.dao.TeacherDAO;
import cn.jhc.zx.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("teacherService")
public class TeacherService
{
//	@Autowired
//	@Qualifier("teacherDAO")  //要和@Autowired组合使用
	@Resource(name="teacherDAO")  //需要javax.annotation包
	private TeacherDAO dao;
	
	public TeacherService(TeacherDAO dao) {
		this.dao=dao;
	}
	
	public TeacherService() {
		
	}
	
	private void setTeacherDAO(TeacherDAO teacherDAO)
	{
		this.dao=teacherDAO;
	}
	
	public void save(Teacher t) {
		dao.save(t);
	}

	@PostConstruct  //需要javax.annotation包
	private void init()
	{
		System.out.println("初始化方法执行了");
	}

	@PreDestroy  //需要javax.annotation包
	private void destory()
	{
		System.out.println("销毁方法执行了");
	}
}
