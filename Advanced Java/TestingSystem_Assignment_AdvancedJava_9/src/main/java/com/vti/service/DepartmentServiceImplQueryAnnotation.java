package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.repository.DepartmentRepositoryQueryAnnotation;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

@Service("DepartmentServiceImplQueryAnnotation")
public class DepartmentServiceImplQueryAnnotation implements DepartmentService {

	@Autowired
	private DepartmentRepositoryQueryAnnotation departmentrepository;
	
	public List<DepartmentDTO> getAllDepartments(){
		
		List<Department> departments = departmentrepository.findAll();
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		
		for (Department department : departments) {
			departmentDTOs.add(new DepartmentDTO(department));
		}
		return departmentDTOs;
	}
	
	@Override
	public List<DepartmentDTO> getAllDepartments(Pageable pageable, FilterDepartment filter) {
		
		List<Department> departments;
		
		if(filter.getMinMember() != null && filter.getMaxMember() == null)
			departments = departmentrepository.findByTotalMemberGreaterThanEqual(filter.getMinMember().shortValue(), pageable).toList();
		else if(filter.getMinMember() == null && filter.getMaxMember() != null)
			departments = departmentrepository.findByTotalMemberLessThanEqual(filter.getMaxMember().shortValue(), pageable).toList();
		else if(filter.getMinMember() != null && filter.getMaxMember() != null)
			departments = departmentrepository.findByTotalMemberBetween(filter.getMinMember().shortValue(), filter.getMaxMember().shortValue(), pageable).toList();
		else
			departments = departmentrepository.findAll(pageable).toList();
		
		
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		
		for (Department department : departments) {
			departmentDTOs.add(new DepartmentDTO(department));
		}
		return departmentDTOs;
	}
	
	public long getTotalCount(String search, String filter) {
		return 0;
	}

	public DepartmentDTO getDepartmentByID(short id) {
		Department department = departmentrepository.findById(id);
		DepartmentDTO departmentDTO = null;
		
		departmentDTO = new DepartmentDTO(department);
		return departmentDTO;
	}

	public DepartmentDTO getDepartmentByName(String name) {
		Department department = departmentrepository.findByName(name);
		DepartmentDTO departmentDTO = null;
		
		departmentDTO = new DepartmentDTO(department);
		return departmentDTO;
	}

	@Validated(onCreate.class)
	public void createDepartment(@Valid Department department) {
		departmentrepository.createDepartment(department.getTotalMember(), department.getName());;
	}

	public void updateDepartment(short id, String newName) {
		
		Department department = departmentrepository.findById(id);
		
		departmentrepository.updateDepartment(department.getTotalMember(), newName, id);
	}

	@Validated(onUpdate.class)
	public void updateDepartment(@Valid Department department) {
		departmentrepository.updateDepartment(department.getTotalMember(), department.getName(), department.getId());
	}

	public void deleteDepartment(short id) {
		departmentrepository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		int check = departmentrepository.existsByID(id);
		return check > 0 ? true : false;
				
	}

	public boolean isDepartmentExistsByName(String name) {
		int check = departmentrepository.existsByName(name);
		return check > 0 ? true : false;
	}
}
