package com.vti.entity.Inheritance;

public class HighSchoolStudent extends Student {
	private String clazz;
	private String desiredUniversity;
	
	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}
	
	public String toString() {
		return "id: " + super.getId() + " - Name: " + super.getName() +  " - Class: "
				+ this.clazz + ", Desired University: " + this.desiredUniversity;
	}
}
