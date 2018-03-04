package com.rahul.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course_master")
public class CourseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "course_id")
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "courseEntities")
	private Set<StudentCourseMap> studentCourseMap;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<StudentCourseMap> getStudentCourseMap() {
		return studentCourseMap;
	}

	public void setStudentCourseMap(Set<StudentCourseMap> studentCourseMap) {
		this.studentCourseMap = studentCourseMap;
	}

	
	
	
	
	
	
	
}
