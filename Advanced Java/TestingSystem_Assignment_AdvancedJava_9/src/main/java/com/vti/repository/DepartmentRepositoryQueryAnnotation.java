package com.vti.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;

@Repository
public interface DepartmentRepositoryQueryAnnotation extends JpaRepository<Department, Short> {
	
	@Query("select d from Department d")
	List<Department> findAll();
	
	@Query("select d from Department d where id = ?1")
	Department findById(short id);
	
	@Query("select d from Department d where name = ?1")
	Department findByName (String name);
	
	@Modifying
	@Query(value = "INSERT INTO Department(TotalMember, DepartmentName) VALUES (N'?1', ?2)", nativeQuery = true)
	int createDepartment(short totalMember, String name);
	
	@Modifying
	@Query("UPDATE Department d SET d.totalMember = ?1, d.name = ?2 WHERE d.id = ?3")
	int updateDepartment(short member, String name, short id);
	
	@Modifying
	@Query("DELETE FROM Department d WHERE d.id = ?1")
	void deleteDepartment(short id);
	
	@Query("select COUNT(d) from Department d where d.id = ?1")
	int existsByID(short id);
	
	@Query("select COUNT(d) from Department d where d.name = ?1")
	int existsByName(String name);
	
	
	@Query("select d from Department d where d.totalMember <= ?1")
	Page<Department> findByTotalMemberLessThanEqual(short max, Pageable pageable);
	
	@Query("select d from Department d where d.totalMember >= ?1")
	Page<Department> findByTotalMemberGreaterThanEqual(short min, Pageable pageable);
	
	@Query("select d from Department d where d.totalMember BETWEEN ?1 AND ?2")
	Page<Department> findByTotalMemberBetween(short min, short max, Pageable pageable);
}
