package com.vti.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Short> {
	
	Page<Department> findByTotalMemberLessThanEqual(short max, Pageable pageable);
	
	Page<Department> findByTotalMemberGreaterThanEqual(short min, Pageable pageable);
	
	Page<Department> findByTotalMemberBetween(short min, short max, Pageable pageable);
	
	
	Optional<Department> findByName (String name);
	
	boolean existsByName(String name);
}
