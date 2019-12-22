package com.chrisxie.hibernate.student;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			
			selectAllTable(session);
			
			selectLastNameNiu(session);
			
			selectAllGmails(session);
			
			
			session.getTransaction().commit();
			
			
		} catch (SessionException e) {

			System.err.println(e);
			 
		}finally {
			// TODO: handle finally clause
		
			System.out.println("Querying completed");
		
			factory.close();
			
		}
		
	}

	private static void selectAllTable(Session session) {
		
		System.out.println("\n\nListing all users from the table....");
		
		List<Student> studentList = session.createQuery("from Student").getResultList();
		 
		studentList.forEach( student -> System.out.println(student) );
	}

	private static void selectLastNameNiu(Session session) {
		
		System.out.println("\n\nListing all users with last name \"Niu\"....");
		
		List<Student> studentList = session.createQuery("from Student where lastName='Niu'").getResultList();
		 
		studentList.forEach( student -> System.out.println(student) );
	}
	
	
	private static void selectAllGmails(Session session) {
		
		System.out.println("\n\nListing all users who use gamil....");
		
		List<Student> studentList = session.createQuery("from Student where email like '%gmail.com'").getResultList();
		 
		studentList.forEach( student -> System.out.println(student) );
	}
	
	
}
