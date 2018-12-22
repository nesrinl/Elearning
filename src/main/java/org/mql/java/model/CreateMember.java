package org.mql.java.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Member;

public class CreateMember {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Member.class).buildSessionFactory()
			;
		
		Session session = factory.getCurrentSession();
		 try {
			 System.out.println("Creating new member");
			 Member m1= new Member("Meryem","Rahmouni","123","meryem@mail.com");
			 session.beginTransaction();
			 System.out.println("Saving member...!");
			 session.save(m1);
			 session.getTransaction().commit();
			 System.out.println("done....! ");
			 
			 
		 } 
		 finally{
			  factory.close();
		 }
		
		

	}

}
