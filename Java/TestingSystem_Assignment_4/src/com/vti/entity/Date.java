package com.vti.entity;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return this.day+"/"+this.month+"/"+this.year;
	}
	
	public boolean isLeapYear() {
		if(this.year % 4 == 0) {
			return true;
		}
		else
			return false;
	}
}
