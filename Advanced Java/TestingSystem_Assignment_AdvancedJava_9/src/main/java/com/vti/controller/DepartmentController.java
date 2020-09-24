package com.vti.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.service.DepartmentService;
import com.vti.utils.Sorting;

@RestController
@RequestMapping(value = "/departments")
@CrossOrigin(origins = "http://127.0.0.1:5501")
@Validated
public class DepartmentController {

	@Autowired
	@Qualifier("DepartmentServiceImpl")
	private DepartmentService departmentservice;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
		
		List<DepartmentDTO> departments = departmentservice.getAllDepartments();
		
		return new ResponseEntity<List<DepartmentDTO>>(departments, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> getAllDepartments(@RequestParam(required = false) @NotNull int page, Sorting sorting, FilterDepartment filter) {
		
		Pageable pageable;
		if(sorting.getField() != null && sorting.getType() != null) {
			if("desc".equals(sorting.getType().toLowerCase()))
				pageable = PageRequest.of(page, 6, Sort.by(sorting.getField()).descending());
			else
				pageable = PageRequest.of(page, 6, Sort.by(sorting.getField()).ascending());
		}
		else
			pageable = PageRequest.of(page, 6);
		
		List<DepartmentDTO> departments = departmentservice.getAllDepartments(pageable, filter);
		
		return new ResponseEntity<List<DepartmentDTO>>(departments, HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<DepartmentDTO>(departmentservice.getDepartmentByID(id), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
		
		departmentservice.createDepartment(departmentDTO.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO departmentDTO) {
		
		Department department = departmentDTO.toEntity();
		department.setId(id);
		departmentservice.updateDepartment(department);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		departmentservice.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
