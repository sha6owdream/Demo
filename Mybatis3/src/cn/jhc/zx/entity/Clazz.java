package cn.jhc.zx.entity;

import java.util.List;

public class Clazz {
	private int clazz;
	private String clazzName;
	private List<Clazz> students;
	
	public Clazz() {
		super();
	}
	public Clazz(int clazz, String clazzName) {
		super();
		this.clazz = clazz;
		this.clazzName = clazzName;
	}
	public int getClazz() {
		return clazz;
	}
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public List<Clazz> getStudents() {
		return students;
	}
	public void setStudents(List<Clazz> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Clazz [clazz=" + clazz + ", clazzName=" + clazzName
				+  "]";
	}
	
	
	
}
