package com.chrisxie.hb_student_tracker.course_student;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chrisxie.hb_student_tracker.entity.Course;
import com.chrisxie.hb_student_tracker.entity.CourseReview;
import com.chrisxie.hb_student_tracker.entity.Instructor;
import com.chrisxie.hb_student_tracker.entity.InstructorDetail;
import com.chrisxie.hb_student_tracker.entity.Student;
import com.chrisxie.hb_student_tracker.student.DateUtil;

public class CourseStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(CourseReview.class)
				.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			
			
			
			List<Student> students = new LinkedList<>();
			
			List<Course> courses = new LinkedList<>();
			
			students = session.createQuery("from Student").getResultList();
			
			courses = session.createQuery("from Course").getResultList();
			
			System.out.println("\n\nReading the Student table...");
			
			students.forEach(s-> System.out.println(s));
			
			System.out.println("\n\nReading the Course table...");
			
			courses.forEach(c->System.out.println(c));
			
			
			Student tmpStudent = new Student("Lu", "Niu", "niulu0809@gmail.com", DateUtil.convertStringToDate("08/09/1994"));
			
			session.save(tmpStudent);
			
			Course tmpCourse = session.get(Course.class, 5);
			
			
			
			
			
			
			
System.out.println("\n\nReading the courses of this student...");
			
			System.out.println(tmpStudent.getCourseList());
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
	}

}
