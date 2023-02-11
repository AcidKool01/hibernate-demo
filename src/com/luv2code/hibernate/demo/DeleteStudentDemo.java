package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// retrieve student by the ID
			System.out.println("\nGetting Student with id: " + studentId);	
			Student myStudent = session.get(Student.class, studentId);
			
			// delete the student 
			
			// Approach 1
			   // session.delete(myStudent);
			
			// Approach 2
				session.createQuery("delete from Student where id=2")
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
