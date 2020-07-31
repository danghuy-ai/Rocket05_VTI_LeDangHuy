package com.vti.entity.Abstraction;

public class Waiter extends User {

	public Waiter(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		double money = super.getSalaryRatio() * 220;
		return money;
	}
}
