package com.chrisxie.hb_student_tracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_review")
public class CourseReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
	
	
	public CourseReview() {
		// TODO Auto-generated constructor stub
	}


	public CourseReview(String comment) {
		
		this.comment = comment;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}



	@Override
	public String toString() {
		return "CourseReview [id=" + id + ", comment=" + comment + "]";
	}
	
	
	
	
	
	
	
}
