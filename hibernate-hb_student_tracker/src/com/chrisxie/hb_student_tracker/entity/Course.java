package com.chrisxie.hb_student_tracker.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH,CascadeType.PERSIST} )
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<CourseReview> courseReviewList;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name = "course_student",
	joinColumns = @JoinColumn(name="course_id"),
	inverseJoinColumns = @JoinColumn(name="student_id")
	)
	private List<Student> studentList;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(String title) {
		
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}




	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	public List<CourseReview> getCourseReviewList() {
		return courseReviewList;
	}
	
	public void setCourseReviewList(List<CourseReview> courseReviewList) {
		this.courseReviewList = courseReviewList;
	}
	
	
	//Convenience method for unidirectional relationship
	public void addCourseReview(CourseReview courseReview) {
		
		if (courseReviewList == null) {
			
			courseReviewList = new LinkedList<>();
			
		}
		
		courseReviewList.add(courseReview);
		
		
	}
	
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	//convenience method for many to many relationship
	public void addStudents(Student student) {
		
		if (studentList == null) {
			
			studentList = new LinkedList<>();
			
		}
		
		studentList.add(student);
		
		
		
		
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title  + ", instructor=" + instructor
				+ "]";
	}
	
	
	
	
	
	
	
}
