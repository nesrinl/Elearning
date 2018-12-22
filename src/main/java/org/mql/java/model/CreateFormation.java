package org.mql.java.model;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Module;
import org.mql.java.entities.Timing;

public class CreateFormation {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Formation.class)
							.addAnnotatedClass(Module.class)
							.addAnnotatedClass(Timing.class)
							.buildSessionFactory()
			;
		
		Session session = factory.getCurrentSession();
		 try {
			 
			 Formation formation = new Formation("MQL", "Monday", "Mr chenfour", "master specialisé");
			 
		/*	 Module mod1 = new Module("php", "web dynamique", 6, "Info");
			 Timing tim1 = new Timing("thusday", 15, 30, 2);
			 mod1.setTiming(tim1);
			 Module mod2 = new Module("Jee", "web", 4, "Info");
			 Timing tim2 = new Timing("friday", 8, 30, 2);
			 mod2.setTiming(tim2);
			 Vector<Module> modfor = new Vector<Module>();
			 modfor.add(mod1);
			 modfor.add(mod2);
			 formation.setModules(modfor);*/
			 
			 System.out.println("Creating new formation");
			 session.beginTransaction();
			 session.save(formation);
			 session.getTransaction().commit();
			 System.out.println("done....! ");
			 
			 
		 } 
		 finally{
			 session.close();
			  factory.close();
		 }
	}
}
