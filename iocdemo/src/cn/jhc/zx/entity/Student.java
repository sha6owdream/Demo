package cn.jhc.zx.entity;

import java.io.Serializable;

public class Student implements Serializable {
	
	private int sno;
	private String sname;
	private int age;
	
	public Student()
	{
		
	}
	
	public Student(int age)
	{
		this.age=age;
	}
	
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
		return "Student [sno=" + sno + ", sname=" + sname + ", age=" + age + "]";
	}
	
	public void myInit() {
        System.out.println("student bean init");
    }

    public void myDestroy() {
        System.out.println("student bean destory");
    }
	
}
