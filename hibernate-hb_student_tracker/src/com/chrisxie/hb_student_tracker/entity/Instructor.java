package com.chrisxie.hb_student_tracker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}, 
			fetch = FetchType.LAZY)//Lazy loading
	private List<Course> courseList;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id" )
	private InstructorDetail instructorDetail;
	
	
	
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	public List<Course> getCourseList() {
		return courseList;
	}
	
	
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	
	//Convenience method for bidirectional relationship Adding
	public void addCourse(Course course) {
		
		if (courseList == null) {
			
			courseList = new ArrayList<>();
			
		}
		
		courseList.add(course);
		
		course.setInstructor(this);
			
	}
	
	//Convenience method for bidirectional relationship removing
	public void removeCourse(Course course) {
		
		courseList.remove(course);
		
		course.setInstructor(null);
		
	}
	
	
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	
	
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "] ";
	}
	
	
	
	
	
	
	
	
}
