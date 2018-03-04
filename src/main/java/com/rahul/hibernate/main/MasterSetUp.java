package com.rahul.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rahul.hibernate.configurations.HibernateConfig;
import com.rahul.hibernate.entity.CourseEntity;
import com.rahul.hibernate.entity.DepartmentEntity;

public class MasterSetUp {
	
	public void setUpDepartMent(){
		SessionFactory session = HibernateConfig.getSessionFactory();
		Session con = session.openSession();
		Transaction tx = con.beginTransaction();
		try {
			DepartmentEntity dept = new DepartmentEntity();
			dept.setDeptName("Computer Science");
			DepartmentEntity dept2 = new DepartmentEntity();
			dept2.setDeptName("Mathematics");
			con.save(dept);
			con.save(dept2);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public void truncateDepartment(){
		SessionFactory session = HibernateConfig.getSessionFactory();
		Session con = session.openSession();
		Transaction tx = con.beginTransaction();
		try {
			con.createSQLQuery("truncate table department_master").executeUpdate();
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	
	public void setUpCourse() {
		SessionFactory session = HibernateConfig.getSessionFactory();
		Session con = session.openSession();
		Transaction tx = con.beginTransaction();
		try {
			CourseEntity ce = new CourseEntity();
			ce.setCourseName("Data structures");
			CourseEntity ce2 = new CourseEntity();
			ce2.setCourseName("Differentiation");
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	
	public void truncateCourse() {
		SessionFactory session = HibernateConfig.getSessionFactory();
		Session con = session.openSession();
		Transaction tx = con.beginTransaction();
		try {
			con.createSQLQuery("truncate table course_master").executeUpdate();
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	
	
	public void initSetting(){
		truncateDepartment();
		truncateCourse();
		setUpDepartMent();
		setUpCourse();
	}
}
