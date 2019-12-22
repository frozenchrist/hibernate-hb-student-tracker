package com.chrisxie.hibernate.course;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hibernate.demo.entity.Course;
import com.chrisxie.hibernate.demo.entity.Instructor;
import com.chrisxie.hibernate.demo.entity.InstructorDetail;
import com.chrisxie.hibernate.student.DateUtil;

public class courseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
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

			
			session.createQuery("from Instructor").getResultList()
			.forEach( i-> System.out.println(i) );
			
			instructorToDelete.getCourseList().forEach( c -> System.out.println(c));
			
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
	}

}
