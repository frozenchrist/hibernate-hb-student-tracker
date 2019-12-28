package com.chrisxie.hb_student_tracker.course;

import java.util.LinkedList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.chrisxie.hb_student_tracker.entity.Course;
import com.chrisxie.hb_student_tracker.entity.CourseReview;
import com.chrisxie.hb_student_tracker.entity.Instructor;
import com.chrisxie.hb_student_tracker.entity.InstructorDetail;
import com.chrisxie.hb_student_tracker.student.DateUtil;

public class courseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(CourseReview.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor instructor = new Instructor("a", "b", "ab@a.com");
			instructor.setInstructorDetail(
					new InstructorDetail("ab.youtube", DateUtil.convertStringToDate("09/11/1234") )
			);
			//session.save(instructor);
			
			
			Instructor instructorToDelete = session.get(Instructor.class, 6);
			
//			Course course1 = session.get(Course.class, 2);
//			
//			Course course2 = session.get(Course.class, 3);
//			
//			instructorToDelete.add(course1);
//			
//			instructorToDelete.add(course2);
			
			//session.save(instructorToDelete);
			
			//instructorToDelete.getCourseList().forEach( course -> course.setInstructor(null)  );
			
			//instructorToDelete.setCourseList(null);
			
			
			
			//InstructorDetail instructorDetail = session.get(InstructorDetail.class, 103);
			
			//session.delete(instructorToDelete);

//			Course course = session.get(Course.class, 2);
//			
//			session.delete(course);
			
			
//			session.createQuery("from Instructor").getResultList()
//			.forEach( i-> System.out.println(i) );
//			
//			instructorToDelete.getCourseList().forEach( c -> System.out.println(c));
			
			
			
			int instructorId = 6;
			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " 
			+ "join fetch i.courseList " 
			+ "where i.id=:instructorId",
				Instructor.class);
			
			query.setParameter("instructorId", instructorId);
			
			instructorToDelete = query.getSingleResult();
			
			
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println(instructorToDelete);
			
			System.out.println(instructorToDelete.getCourseList());
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//session.close();
			
			factory.close();
		}
		
	}

}
