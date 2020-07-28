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
//		
//		Question5(dep1,dep2);
//		
//		Question6();
		System.out.println("a".compareToIgnoreCase("d"));
		
		Question7();
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
	
	static void Question5(Department dep1, Department dep2) {
		if (dep1.equals(dep2)) {
			System.out.println("Có bằng nhau!");
		} else {
			System.out.println("Không bằng nhau!");
		}
	}
	
	static void Question6() {
		Department[] departments = new Department[5];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Accounting");
		Department dep3 = new Department(3, "Waiting room");
		Department dep4 = new Department(4, "Boss of director");
		Department dep5 = new Department(5, "Sale");
		
		departments[0] = dep1;
		departments[1] = dep2;
		departments[2] = dep3;
		departments[3] = dep4;
		departments[4] = dep5;
		
		for (int i = 0; i < departments.length; i++) {
			for (int j = i + 1; j < departments.length; j++) {
				if(departments[i].departmentName.compareToIgnoreCase(departments[j].departmentName) > 0) {
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}
		System.out.println("Dang sách phòng ban theo thứ tự tăng dần theo tên:");
		for (Department department : departments ) {
			System.out.println(department.departmentName);
		}
	}
	
	static void Question7() {
		Department[] departments = new Department[5];
		Department dep1 = new Department(1, "Marketing");
		Department dep2 = new Department(2, "Accounting");
		Department dep3 = new Department(3, "Waiting room");
		Department dep4 = new Department(4, "Boss of director");
		Department dep5 = new Department(5, "Sale");
		
		departments[0] = dep1;
		departments[1] = dep2;
		departments[2] = dep3;
		departments[3] = dep4;
		departments[4] = dep5;
		
		for (int i = 0; i < departments.length; i++) {
			String str1 = getLastPhrase(departments[i].departmentName);
			for (int j = i + 1; j < departments.length; j++) {
				String str2 = getLastPhrase(departments[j].departmentName);
				if (str1.compareToIgnoreCase(str2) > 0) {
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}
		System.out.println("\nDang sách phòng ban được sắp xếp theo tên:");
		for (Department department : departments ) {
			System.out.println(department.departmentName);
		}
	}
	
	static String getLastPhrase (String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");

		String[] words = str.split(" ");
		String kiemTra = "";
		
		for (int i = words.length - 1; i >= 0; i--) {
			kiemTra += words[i] + " ";
		}
		//System.out.println(kiemTra.substring(0, 2));
		
		return kiemTra.substring(0, 2 );
	}
	
	
	
	
}
