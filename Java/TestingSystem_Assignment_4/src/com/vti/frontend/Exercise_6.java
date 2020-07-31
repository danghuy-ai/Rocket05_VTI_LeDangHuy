package com.vti.frontend;

import com.vti.entity.Abstraction.Employee;
import com.vti.entity.Abstraction.Manager;
import com.vti.entity.Abstraction.VietnamesePhone;
import com.vti.entity.Abstraction.Waiter;

public class Exercise_6 {

	public static void main(String[] args) {
		//Question 1
		VietnamesePhone newPhone = new VietnamesePhone();
		
		newPhone.insertContact("Huy", "0979814238");
		newPhone.insertContact("Minh", "113333");
		
		newPhone.info();
		
		newPhone.updateContact("Huy", "123");
		newPhone.info();
		
		newPhone.searchContact("Minh");
		
		newPhone.removeContact("Minh");
		newPhone.info();
		
		
		//Question 2+3
		Employee employee = new Employee("Đăng Black", 6.9);
		employee.displayInfor();
		//System.out.println(employee.calculatePay());

		Manager manager = new Manager("Quang Anh", 9.6);
		manager.displayInfor();

		Waiter waiter = new Waiter("Chiến Panda", 2.6);
		waiter.displayInfor();
	}

}
