package com.rahul.hibernate.configurations;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.rahul.hibernate.entity.CourseEntity;
import com.rahul.hibernate.entity.DepartmentEntity;
import com.rahul.hibernate.entity.RollNumberEntity;
import com.rahul.hibernate.entity.StudentCourseMap;
import com.rahul.hibernate.entity.StudentEntity;


public class HibernateConfig {

	  protected static SessionFactory newSessionFactory() {
	      Properties properties = new Properties();
	      properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	      //log settings
	      properties.put("hibernate.hbm2ddl.auto", "update");
	      properties.put("hibernate.show_sql", "true");
	      //driver settings
	      properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	      properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/student_db");
	      properties.put("hibernate.connection.username", "root");
	      properties.put("hibernate.connection.password", "root");
	      
	   
	      return new Configuration()
	              .addProperties(properties)
	              .addAnnotatedClass(StudentEntity.class)
	              .addAnnotatedClass(DepartmentEntity.class)
	              .addAnnotatedClass(StudentCourseMap.class)
	              .addAnnotatedClass(CourseEntity.class)
	              .addAnnotatedClass(RollNumberEntity.class)
	              .buildSessionFactory(
	                      new StandardServiceRegistryBuilder()
	                              .applySettings(properties)
	                              .build()
	      );
	  }
	  //Utility method to return SessionFactory
	  public static SessionFactory getSessionFactory() {
		  return newSessionFactory();
	  }
}
