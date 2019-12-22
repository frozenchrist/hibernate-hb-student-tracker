package com.chrisxie.hibernate.instructors;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hibernate.demo.entity.Course;
import com.chrisxie.hibernate.demo.entity.Instructor;
import com.chrisxie.hibernate.demo.entity.InstructorDetail;
import com.chrisxie.hibernate.student.DateUtil;

public class instructorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			 
			session.beginTransaction();
			
			
			ReadInstructor(session);
		
			
			
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		finally {
			
			session.close();
			
			factory.close();
			
		}
		
		
		
		
	}

	
	//Create
	private static void createInstructor(Session session) throws ParseException {
		
		Instructor instructorToSave = new Instructor("Lu", "Xie", "chris@gamil.com");
		
		instructorToSave.setInstructorDetail(new InstructorDetail("chris.youtube.com", DateUtil.convertStringToDate("08/11/1995")));
		
		session.save(instructorToSave);
	
		
//		InstructorDetail instructorDetailToSave = new InstructorDetail("chris.youtube.com", DateUtil.convertStringToDate("08/11/1995"));
//		
//		instructorDetailToSave.setInstructor(new Instructor("Chris", "Xie", "chris@gmail.com"));
//		
//		session.save(instructorDetailToSave);
	}
	
	
	//Read
private static void ReadInstructor(Session session) throws ParseException {
		
//		int instructorId = 1;
//		
//		System.out.println("Reading the instructor by id: " + instructorId + "....");
//		
//		Instructor instructorToRead = session.get(Instructor.class, instructorId);
//		
//		System.out.println(instructorToRead);
		
		
		System.out.println("\nReading the instructor table....");
	
		session.createQuery("from Instructor")
				.getResultList().forEach( instructor -> System.out.println(instructor) );
		
		
		
	
	}
	

	//Delete
	private static void deleteInstructor(Session session) throws ParseException {
	
//	int instructorId = 1;
//	
//	Instructor instructorToDelete = session.get(Instructor.class, instructorId);
//	
//	
//	System.out.println("Instructor found: " + instructorToDelete);
//		
//	System.out.println("Deleting...");
//	
//	session.delete(instructorToDelete);
	
	
		int instructorDetailId = 101;
		
		InstructorDetail instructorDetailToDelete = session.get(InstructorDetail.class, instructorDetailId);
		
		
		//Break the relational link
		instructorDetailToDelete.getInstructor().setInstructorDetail(null);
		
		System.out.println("Instructor Detail found: " + instructorDetailToDelete);
	
		System.out.println("Deleting...");
		
		session.delete(instructorDetailToDelete);
		
}



}
