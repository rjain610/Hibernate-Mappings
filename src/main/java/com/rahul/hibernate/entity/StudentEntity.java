package com.rahul.hibernate.entity;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_master")
public class StudentEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "department_id")
	private int departmentId;
	
	@ManyToOne
	@JoinColumn(name = "department_id", insertable = false , updatable = false)
	private DepartmentEntity departmentEntity;
	
	@OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id",insertable = false , updatable = false)
	private RollNumberEntity rollNumberEntity;
	
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id",insertable = false , updatable = false )
	private StudentCourseMap studentCourseMaps;
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	public RollNumberEntity getRollNumberEntity() {
		return rollNumberEntity;
	}

	public void setRollNumberEntity(RollNumberEntity rollNumberEntity) {
		this.rollNumberEntity = rollNumberEntity;
	}

	public StudentCourseMap getStudentCourseMaps() {
		return studentCourseMaps;
	}

	public void setStudentCourseMaps(StudentCourseMap studentCourseMaps) {
		this.studentCourseMaps = studentCourseMaps;
	}
	
	
	
}
