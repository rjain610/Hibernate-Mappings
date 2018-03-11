package com.rahul.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rahul.hibernate.configurations.HibernateConfig;
import com.rahul.hibernate.entity.CourseEntity;
import com.rahul.hibernate.entity.DepartmentEntity;
import com.rahul.hibernate.entity.RollNumberEntity;
import com.rahul.hibernate.entity.StudentCourseMap;
import com.rahul.hibernate.entity.StudentEntity;



public class InsertMain {
	public static void main(String[] args) {
		MasterSetUp ms = new MasterSetUp();
	//	ms.initSetting();
		SessionFactory session = HibernateConfig.getSessionFactory();

		Session con = session.openSession();
		Transaction tx = con.beginTransaction();
		try{
			
			
			DepartmentEntity departmentEntity = (DepartmentEntity) con.load(DepartmentEntity.class, 1);
			CourseEntity ce  = (CourseEntity) con.load(CourseEntity.class, 1);
			
			
			
			StudentEntity student = new StudentEntity();
			student.setStudentName("Alex");
			student.setDepartmentEntity(departmentEntity);
			RollNumberEntity rollNumberEntity = new RollNumberEntity();
			rollNumberEntity.setRollNumber(1001);
			rollNumberEntity.setStudentEntity(student);
			student.setRollNumberEntity(rollNumberEntity);
			
			Set<StudentEntity> se = new HashSet<StudentEntity>();
			se.add(student);
 			
			StudentCourseMap studentCourseMaps = new StudentCourseMap();
			studentCourseMaps.setCourseEntities(ce);
			studentCourseMaps.setStudentEntity(se);
			student.setStudentCourseMaps(studentCourseMaps);
			con.save(student);
			//con.save(rollNumberEntity);
			//con.save(studentCourseMaps);
			tx.commit();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
