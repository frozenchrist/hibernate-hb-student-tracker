package com.chrisxie.hb_student_tracker.course_review;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hb_student_tracker.entity.Course;
import com.chrisxie.hb_student_tracker.entity.CourseReview;
import com.chrisxie.hb_student_tracker.entity.Instructor;
import com.chrisxie.hb_student_tracker.entity.InstructorDetail;

public class CourseReviewApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(CourseReview.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			Course tempCourse = session.get(Course.class, 8);
			
			CourseReview tempCourseReview = session.get(CourseReview.class, 10);
			
			session.delete(tempCourseReview);
	
		
			
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			session.close();
			
			factory.close();
			
		}
		
		
		
		
	}

}
