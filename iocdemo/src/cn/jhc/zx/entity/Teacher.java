package cn.jhc.zx.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("teacher")
//@Scope("prototype")  //当前为单例，解开注释为多例
public class Teacher implements Serializable
{

	@Value("123")
	private int sno;
	
	@Value("Jax")
	private String sname;
	
	public int getSno()
	{
		return sno;
	}
	public void setSno(int sno)
	{
		this.sno = sno;
	}
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	@Override
	public String toString()
	{
		return "Teacher [sno=" + sno + ", sname=" + sname + "]";
	}


	
	
	
}
