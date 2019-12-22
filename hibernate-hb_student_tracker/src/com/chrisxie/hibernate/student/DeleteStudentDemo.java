package com.chrisxie.hibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			//delete one by one
			session.beginTransaction();
			
//			Student studentToDelete = session.get(Student.class, 3);
//			
//			session.delete(studentToDelete);
			
			//delete many
			
			session.createQuery("delete Student where birthday = null").executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}finally {
			
			factory.close();
			
		}
		
		
		
		
		
		
		
		
	}

}
