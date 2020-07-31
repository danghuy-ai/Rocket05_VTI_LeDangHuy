package com.vti.entity.Abstraction;

public class Manager extends User {

	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		double money = super.getSalaryRatio() * 520;
		return money;
	}
}
