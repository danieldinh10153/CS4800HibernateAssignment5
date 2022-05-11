package problem5_2a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
				
		//make session
		Session session = factory.getCurrentSession();
		
		try { //slide 37

			Professor prof = session.get(Professor.class, 1);
			session.delete(prof);
			
			Customer cust = session.get(Customer.class, 1);
			session.delete(cust);
			
			//start transaction
			session.beginTransaction();
			
			//commit
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
		
	}

}
