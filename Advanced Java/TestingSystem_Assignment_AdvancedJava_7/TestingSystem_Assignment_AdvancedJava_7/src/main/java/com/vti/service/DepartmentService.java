package com.vti.service;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;

public interface DepartmentService {
	
	public List<DepartmentDTO> getAllDepartments();

	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize, String search, String filter, String sort);
	
	public long getTotalCount(String search, String filter);

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(short id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
