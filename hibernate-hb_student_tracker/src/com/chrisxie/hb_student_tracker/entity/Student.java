package com.chrisxie.hb_student_tracker.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "birthday")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "email")
	private String email;

	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH},
			fetch = FetchType.LAZY)
	@JoinTable(name = "course_student",
	joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")		
	)
	private List<Course> courseList;
	
	
	public Student() { 
		// TODO Auto-generated constructor stub
	}


	public Student(String firstName, String lastName, String email, Date birthday) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday=birthday;
	}


	//ID
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	//Name
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


	//birthday
	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	//Email
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
	
	
	//convenient method for adding course to the student
	public void addCourses(Course course) {
		
		if (courseList == null) {
			
			courseList = new LinkedList<>();
			
		}
		
		
		courseList.add(course);
		
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", email=" + email + "]";
	}
	
	
	
}
