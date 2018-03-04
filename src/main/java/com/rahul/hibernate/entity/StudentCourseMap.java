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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_course_map")
public class StudentCourseMap  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "course_id")
	private int courseId;
	
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "studentCourseMaps")
	private Set<StudentEntity> studentEntity;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", insertable = false , updatable = false)
	private CourseEntity courseEntities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Set<StudentEntity> getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(Set<StudentEntity> studentEntity) {
		this.studentEntity = studentEntity;
	}

	public CourseEntity getCourseEntities() {
		return courseEntities;
	}

	public void setCourseEntities(CourseEntity courseEntities) {
		this.courseEntities = courseEntities;
	}

	
	
	
}
