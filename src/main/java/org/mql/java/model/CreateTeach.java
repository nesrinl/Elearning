package org.mql.java.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Member;
import org.mql.java.entities.Module;
import org.mql.java.entities.Streaming;
import org.mql.java.entities.Timing;

public class CreateTeach {

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
 System.out.println("Creating new teach");
			 
			 session.beginTransaction();
			 int mod_id = 1;
			 Module mod = session.get(Module.class, mod_id);
			 
			 Member memb = new Member("nesrin", "lakhal", "nisrin.lakhal01@gmail.com", "");
			 session.save(memb);
			 
			 memb.addModules(mod);
			 session.save(memb);
			 session.getTransaction().commit();
			 System.out.println("Khedmat ...!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
