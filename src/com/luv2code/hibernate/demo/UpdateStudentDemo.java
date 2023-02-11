package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;

			// get a session & start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			// 1: ID BASED UPDATE
			
			// retrieve student based on id: primary key
//			System.out.println("\nGetting Student with id: " + studentId);
//						
//			Student myStudent = session.get(Student.class, studentId);
//			
//			System.out.println("Updating Student...");
//			myStudent.setFirstName("Scooby");
			
			// 2: UPDATE EMAIL FOR ALL
			
			System.out.println("update email id");
			session.createQuery("update Student set email='foo@gmail.com'")
				.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

}
