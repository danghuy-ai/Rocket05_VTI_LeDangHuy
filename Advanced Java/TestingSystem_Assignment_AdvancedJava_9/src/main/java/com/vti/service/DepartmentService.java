package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;

public interface DepartmentService {
	
	public List<DepartmentDTO> getAllDepartments();

	public List<DepartmentDTO> getAllDepartments(Pageable pageable, FilterDepartment filter);
	
	public long getTotalCount(String search, String filter);

	public DepartmentDTO getDepartmentByID(short id);

	public DepartmentDTO getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(short id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
