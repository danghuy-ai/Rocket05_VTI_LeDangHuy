package front_end;

import java.sql.SQLException;
import java.util.List;

import backend.DepartmentDao;
import entity.Department;

public class Program2 {

	public static void main(String[] args) throws SQLException {
		
		List<Department> departments = DepartmentDao.getDepartments();
		for (Department department : departments) {
			System.out.println(department.toString());
		}
		DepartmentDao.getDepartmentByID(1);
	}

}
