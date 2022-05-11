package problem5_2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import problem5_2a.Customer;
import problem5_2a.Professor;

public class MainDeleteOrder {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		
		//make session
		Session session = factory.getCurrentSession();
		try { //slide 36
				
			Order tempOrder = session.get(Order.class, 1);
			
			session.beginTransaction();
			
			session.delete(tempOrder);
				
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
