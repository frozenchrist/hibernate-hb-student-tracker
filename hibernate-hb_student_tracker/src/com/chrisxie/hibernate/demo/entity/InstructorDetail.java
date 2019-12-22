package com.chrisxie.hibernate.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chrisxie.hibernate.student.DateUtil;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "birthday")
	private Date birthday;

	@OneToOne(mappedBy = "instructorDetail", 
			cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
	private Instructor instructor;
	
	
	
	
	public InstructorDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public InstructorDetail(String youtubeChannel, Date birthday) {
		this.youtubeChannel = youtubeChannel;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	public Instructor getInstructor() {
		return instructor;
	}
	
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public String toString() {
		return "InstructorDetial [id=" + id + ", youtubeChannel=" + youtubeChannel +
				", birthday=" + DateUtil.convertDateToString(birthday) +"] ";
	}
	 
	
	
	
	
}
