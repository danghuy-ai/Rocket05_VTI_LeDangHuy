package com.vti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.repository.DepartmentRepository;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;
	
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
		Optional<Department> department = departmentrepository.findById(id);
		DepartmentDTO departmentDTO = null;
		
		if (department.isPresent())
			departmentDTO = new DepartmentDTO(department.get());
		return departmentDTO;
	}

	public DepartmentDTO getDepartmentByName(String name) {
		Optional<Department> department = departmentrepository.findByName(name);
		DepartmentDTO departmentDTO = null;
		
		if (department.isPresent())
			departmentDTO = new DepartmentDTO(department.get());
		return departmentDTO;
	}

	@Validated(onCreate.class)
	public void createDepartment(@Valid Department department) {
		departmentrepository.save(department);
	}

	public void updateDepartment(short id, String newName) {
		
		Department department = departmentrepository.findById(id).get();
		department.setName(newName);
		
		departmentrepository.save(department);
	}

	@Validated(onUpdate.class)
	public void updateDepartment(@Valid Department department) {
		departmentrepository.save(department);
	}

	public void deleteDepartment(short id) {
		departmentrepository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return departmentrepository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return departmentrepository.existsByName(name);
	}


}
