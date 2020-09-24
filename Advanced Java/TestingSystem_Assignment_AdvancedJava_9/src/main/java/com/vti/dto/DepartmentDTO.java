package com.vti.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.vti.entity.Department;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

public class DepartmentDTO {
	
	@Min(value = 0, groups = onCreate.class)
	@Min(value = 1, groups = onUpdate.class)
	private short id;
	
	private short totalMember;
	
	@NotNull(groups = {onCreate.class, onUpdate.class})
	private String name;
	
	public DepartmentDTO() {
		
	}
	
	public DepartmentDTO(Department department) {
		this.id = department.getId();
		this.totalMember = department.getTotalMember();
		this.name = department.getName();
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(short totalMember) {
		this.totalMember = totalMember;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department toEntity() {
		return new Department(totalMember, name);
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", totalMember=" + totalMember + ", name=" + name + "]";
	}
}
