package problem5_2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import problem5_2a.Customer;
import problem5_2a.Professor;

public class MainCreateOrder {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		
		//make session
		Session session = factory.getCurrentSession();
		try { //slide 36
				Order tempOrder1 = new Order();
				Order tempOrder2 = new Order();
				
				Product tempProduct1 = new Product("Vans");
				
				tempOrder1.addProduct(tempProduct1);
				tempOrder2.addProduct(tempProduct1);
				
				session.beginTransaction();
				
				session.save(tempOrder1);
				session.save(tempOrder2);
				session.save(tempProduct1);
				
				session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}

