package org.mql.java.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Member;
import org.mql.java.entities.Module;
import org.mql.java.entities.Streaming;
import org.mql.java.entities.Timing;


public class CreateFollowing {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Formation.class)
							.addAnnotatedClass(Member.class)
							.addAnnotatedClass(Module.class)
							.addAnnotatedClass(Timing.class)
							.addAnnotatedClass(Streaming.class)
							.buildSessionFactory()
			;
		
		Session session = factory.getCurrentSession();
		try {
			 System.out.println("Creating new follow");
			 
			 session.beginTransaction();
			 
			 Formation formation = new Formation("Big data", "Monday", "Mr Berrada", "master de recherche");
			 session.save(formation);
			 
			 Member membr1 = new Member("Essadeq", "Hatim", "hatim.essadeq@gmail.com", "");
			 session.save(membr1);
			 
			 Member membr2 = new Member("Alaoui ismaili", "omar", "ismailialaoui.omar@gmail.com", "");
			 session.save(membr2);
			 
			 formation.addMember(membr1);
			 formation.addMember(membr2);
			 
			 session.save(membr1);
			 session.save(membr2);
			 session.getTransaction().commit();
			 System.out.println("Khedmat ...!");
			 
			 
		} finally {
			session.close();
			factory.close();
		}
	}

}
