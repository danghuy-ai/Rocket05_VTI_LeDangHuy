package com.vti.entity.Abstraction;

public class Employee extends User {
	public Employee(String name, double salaryRatio) {
		super(name, salaryRatio);
	}
	
	@Override
	public double calculatePay() {
		double money = super.getSalaryRatio() * 420;
		return money;
	}
}
