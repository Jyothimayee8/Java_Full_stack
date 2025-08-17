package com.amazon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDOperation {
	public static void main(String[] args) {
		//SessionFactory object
		
		SessionFactory factory = HibernateConfig.getSessionFactory();
		
		// Session Object
		
		Session ses = factory.openSession();
		
		
		//Transaction management
		
		Transaction tx = ses.beginTransaction();
		
	/*	// To insert 
		
		Product p = new Product(4001,"Oppo",14000);
		
		ses.save(p);
		
		
		
	
		*/
		
		
		// save
		
		Product p = new Product(52,"lg",5000);
		
		//ses.save(p);
		
		//update
		
		ses.update(p);
		
		
		// delete
		
		ses.delete(p);
		
		//load 
		
		//commit transaction
		
		tx.commit();
		
		//close objects in reverse
		
		ses.close();
		factory.close();
		
		
		
	}

}
