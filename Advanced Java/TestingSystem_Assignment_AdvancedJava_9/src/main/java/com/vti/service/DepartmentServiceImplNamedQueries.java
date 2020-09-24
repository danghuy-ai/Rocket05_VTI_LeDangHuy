package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

@Service("DepartmentServiceImplNamedQueries")
public class DepartmentServiceImplNamedQueries implements DepartmentService {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartments(){
		
		Query q = em.createNamedQuery("Department.findAll");
		
		List<Department> departments = q.getResultList();
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		
		for (Department department : departments) {
			departmentDTOs.add(new DepartmentDTO(department));
		}
		return departmentDTOs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentDTO> getAllDepartments(Pageable pageable, FilterDepartment filter) {
		
		
		Query q;
		
		if(filter.getMinMember() != null && filter.getMaxMember() == null) {
			q = em.createNamedQuery("Department.findByTotalMemberGreaterThanEqual");
			q.setParameter(1, filter.getMinMember().shortValue());
		}
		else if(filter.getMinMember() == null && filter.getMaxMember() != null) {
			q = em.createNamedQuery("Department.findByTotalMemberLessThanEqual");
			q.setParameter(1, filter.getMaxMember().shortValue());
		}
		else if(filter.getMinMember() != null && filter.getMaxMember() != null) {
			q = em.createNamedQuery("Department.findByTotalMemberBetween");
			q.setParameter(1, filter.getMinMember().shortValue());
			q.setParameter(2, filter.getMaxMember().shortValue());
		}
		else
			q = em.createNamedQuery("Department.findAll");
		
		List<Department> departments = q.getResultList();
		
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
		
		Query q = em.createNamedQuery("Department.findById");
		q.setParameter(1, id);
		Department department = (Department) q.getSingleResult();
		DepartmentDTO departmentDTO = new DepartmentDTO(department);
		return departmentDTO;
	}

	public DepartmentDTO getDepartmentByName(String name) {

		Query q = em.createNamedQuery("Department.findByName");
		q.setParameter(1, name);
		Department department = (Department) q.getSingleResult();
		DepartmentDTO departmentDTO = new DepartmentDTO(department);
		return departmentDTO;
	}

	@Validated(onCreate.class)
	public void createDepartment(@Valid Department department) {
		
		Query q = em.createNamedQuery("Department.createDepartment");
		q.setParameter("name", department.getName());
		q.setParameter("member", department.getTotalMember());
		
		q.executeUpdate();
	}

	public void updateDepartment(short id, String newName) {
		
		Query q = em.createNamedQuery("Department.updateDepartment");
		q.setParameter("newName", newName);
		q.setParameter("ID", id);
		
		q.executeUpdate();
	}

	@Validated(onUpdate.class)
	public void updateDepartment(@Valid Department department) {
		
		Query q = em.createNamedQuery("Department.updateDepartment2");
		q.setParameter(1, department.getTotalMember());
		q.setParameter(2, department.getName());
		q.setParameter(3, department.getId());
		
		q.executeUpdate();
	}

	public void deleteDepartment(short id) {

		Query q = em.createNamedQuery("Department.deleteDepartment");
		q.setParameter(1, id);
		
		q.executeUpdate();
	}

	public boolean isDepartmentExistsByID(short id) {
		
		Query q = em.createNamedQuery("Department.existsByID");
		q.setParameter(1, id);
		
		int check = q.getMaxResults();
		return check > 0 ? true : false;
				
	}

	public boolean isDepartmentExistsByName(String name) {

		Query q = em.createNamedQuery("Department.existsByName");
		q.setParameter(1, name);
		
		int check = q.getMaxResults();
		return check > 0 ? true : false;
	}
}
