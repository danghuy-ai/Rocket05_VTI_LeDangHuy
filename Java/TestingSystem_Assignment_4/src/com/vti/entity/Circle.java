package com.vti.entity;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 0.0;
		this.color = "Noname";
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "Color: " + this.color + " - radius: " + this.radius;
	}
	
}
