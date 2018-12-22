package org.mql.java.model;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Module;
import org.mql.java.entities.Streaming;
import org.mql.java.entities.Timing;


public class CreateModule {

	

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Module.class)
							.addAnnotatedClass(Timing.class)
							.addAnnotatedClass(Formation.class)
							.addAnnotatedClass(Streaming.class)
							.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		 try {
		//	 Module mod = new Module("java", "orienté objet", 5, "Info");
			// Timing tim = new Timing("Monday", 14, 00, 2); 
			// mod.setTiming(tim);
			 Module mod1 = new Module("java", "orienté objet", 5, "Info");
			 Timing tim1 = new Timing("Monday", 14, 00, 2); 
			 mod1.setTiming(tim1);
			 Streaming stream = new Streaming("java", "test", "17-1-2019", "2H");
			
			 
			 System.out.println("Creating new Module");
			 
			 session.beginTransaction();
			 int form_id= 1;
			 Formation formation = session.get(Formation.class, form_id);
			 formation.add(mod1); 
			 mod1.add(stream);
			 session.save(mod1);
			 session.save(stream);
			 session.getTransaction().commit();
			 System.out.println("done....! ");
			 
			 
			 
		 } 
		 finally{
			 session.close();
			 factory.close();
		 }
		
		

	}

}
