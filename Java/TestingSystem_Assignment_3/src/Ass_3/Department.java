package Ass_3;

public class Department {
	int departmentID;
	String departmentName;
	
	public Department(int id, String name) {
		departmentID = id;
		departmentName = name;
	}
	
	@Override
	public String toString() {
		return "ID: " + departmentID + ", Name: " + departmentName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}
}
