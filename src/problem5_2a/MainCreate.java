package problem5_2a;


import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MainCreate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
				
		//make session
		Session session = factory.getCurrentSession();
		try { //slide 36
			//customer obj
			Customer cust = new Customer("Daniel", "1176 Arcane Street");
	
			Professor prof = new Professor("8001", "Aliens");
			
			prof.makeCustomer(cust);
			
			//start transaction
			session.beginTransaction();
			
			//save student
			session.save(prof);
			
			//commit
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
