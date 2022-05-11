package problem5_2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import problem5_2a.Customer;
import problem5_2a.Professor;

public class MainCreateProduct {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		
		//make session
		Session session = factory.getCurrentSession();
		try { //slide 36
				Product tempProduct1 = new Product("converse");
				Product tempProduct2 = new Product("DR");
				
				Order tempOrder1 = new Order();
				
				tempOrder1.addProduct(tempProduct1);
				tempOrder1.addProduct(tempProduct2);
				
				session.beginTransaction();
				
				session.save(tempOrder1);
				session.save(tempProduct1);
				session.save(tempProduct2);
				
				session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
