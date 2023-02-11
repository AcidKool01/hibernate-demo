package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			// create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Carry", "min", "carry@luv2code.com");;
			
			// start a transaction
			session.beginTransaction();
					
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
					
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE -- READING/RETRIEVING QUERY
			
			System.out.println("Saved Student. Generated Id: " + tempStudent.getId());
				
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting Student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

}
