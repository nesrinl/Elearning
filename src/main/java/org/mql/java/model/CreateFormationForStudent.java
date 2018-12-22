package org.mql.java.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Member;
import org.mql.java.entities.Module;
import org.mql.java.entities.Streaming;
import org.mql.java.entities.Timing;

public class CreateFormationForStudent {

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
			 
			 int mem_id = 1;
			 Member memb = session.get(Member.class, mem_id);
			 
			 Formation formation = new Formation("WISD", "tursday", "Mr Yahyaoui", "master de recherche");
			 session.save(formation);
			 
			 formation.addMember(memb);
			 session.save(formation);
			 
			 
			 session.getTransaction().commit();
			 System.out.println("Khedmat ...!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
