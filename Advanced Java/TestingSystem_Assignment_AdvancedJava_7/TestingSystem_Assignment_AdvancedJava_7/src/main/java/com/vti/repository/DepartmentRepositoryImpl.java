package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepositoryImpl() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDTO> getAllDepartments() {

		Session session = null;
		List<DepartmentDTO> lists = new ArrayList<DepartmentDTO>();
		
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			cr.addOrder(Order.asc("id"));
			
			List<Department> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new DepartmentDTO(results.get(i).getId(), results.get(i).getName()));
			}
			
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize, String search, String filter, String sort) {

		Session session = null;
		List<DepartmentDTO> lists = new ArrayList<DepartmentDTO>();
		
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			if(search != null) {
				cr.add(Restrictions.ilike("name", "%"+search+"%"));
			}
			else {
				if(filter != null) {
					cr.add(Restrictions.eq("name", filter));
				}
			}
			
			if (sort == null)
				cr.addOrder(Order.asc("id"));
			else if(sort.equals("id"))
				cr.addOrder(Order.asc("id"));
			else if (sort.equals("name"))
				cr.addOrder(Order.asc("name"));
			else
				cr.addOrder(Order.asc("id"));
				
			
			cr.setFirstResult((pageNumber - 1) * pageSize);
			cr.setMaxResults(pageSize);
			
			List<Department> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new DepartmentDTO(results.get(i).getId(), results.get(i).getName()));
			}
			
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings({ "deprecation" })
	public long getTotalCount(String search, String filter) {
		
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			if(search != null) {
				cr.add(Restrictions.ilike("name", "%"+search+"%"));
			}
			else {
				if(filter != null) {
					cr.add(Restrictions.eq("name", filter));
				}
			}
			
			cr.setProjection(Projections.rowCount());
			Long count = (Long) cr.uniqueResult();
			
			return count;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
