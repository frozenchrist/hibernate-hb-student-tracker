package com.chrisxie.hb_student_tracker.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hb_student_tracker.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		
		try {
		
		//update one record only	
		session.beginTransaction();
		
		Student studentToUpdate = session.get(Student.class, 1);
		
		System.out.println(studentToUpdate);	
		
		studentToUpdate.setBirthday(DateUtil.convertStringToDate("08/09/1994"));
		
		//session.createQuery("update Student set birthday = '08/09/1994' where lastName = 'Niu'").executeUpdate();
		
		
		session.getTransaction().commit();
		
		
		
		
//		session = factory.getCurrentSession();
//		
//		session.beginTransaction();
//		
//		session.createQuery("update Student set email = '%gmail.com'").executeUpdate();
//		
//		session.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			factory.close();
			
		}

	}

}
