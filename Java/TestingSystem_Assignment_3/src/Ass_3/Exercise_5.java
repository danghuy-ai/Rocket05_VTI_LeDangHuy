package Ass_3;


public class Exercise_5 {

	public static void main(String[] args) {
		Department[] departments = new Department[5];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Sale");
		Department dep3 = new Department(3, "Giam doc");
		Department dep4 = new Department(4, "Sale");
		Department dep5 = new Department(5, "Phòng A");
		
		departments[0] = dep1;
		departments[1] = dep2;
		departments[2] = dep3;
		departments[3] = dep4;
		departments[4] = dep5;
		
//		Question1(dep1);
//		
//		Question2(departments);
//		
//		Question3(dep1);
//		
//		Question4(dep1);
//		Question4(dep5);
		
		Question5(dep1,dep2);
		
		
	}
	static void Question1(Department department) {
		System.out.println(department);
	}
	
	static void Question2(Department[] departments) {
		for (Department department : departments) {
			System.out.println(department);
		}
	}
	
	static void Question3(Department department) {
		System.out.println(department.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	static void Question4(Department department) {
		if (department.equals("Phòng A")) {
			System.out.println("Phòng ban này có tên là Phòng A");
		} else {
			System.out.println("Phòng ban này không tên là Phòng A");
		}
	}
	
	public static void Question5(Department dep1, Department dep2) {
		if (dep1.equals(dep2)) {
			System.out.println("Có bằng nhau!");
		} else {
			System.out.println("Không bằng nhau!");
		}
	}
}
