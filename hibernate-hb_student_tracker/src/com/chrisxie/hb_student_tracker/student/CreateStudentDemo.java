package com.chrisxie.hb_student_tracker.student;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hb_student_tracker.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Step 1: Create a new Session Factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Step 2: Create a new Session using the Factory
		Session session = factory.getCurrentSession();
		
		try {
			//Step 3: use the session obj to save Java obj
			System.out.println("Creating a new student....");
			
			Student studentToSave = new Student("Chris", "Xie", "chrisxie1995work@gmail.com", DateUtil.convertStringToDate("08/11/1995"));
			
			//Step 4: Start a new transaction
			session.beginTransaction();
			
			//Step 5: Save the obj
			System.out.println("Saving the student.....");
			session.save(studentToSave);
			
			//Step 6: Commit the change
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
		
			System.out.println("Saving completed!!");
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
