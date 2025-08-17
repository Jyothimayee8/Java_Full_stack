package com.library;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDOperations {
	public static void main(String[] args) {
		//SessionFactory object
		
		SessionFactory factory = LibraryConfig.getSessionFactory();
		
		// Session Object
		
		Session ses = factory.openSession();
		
		
		//Transaction management
		
		Transaction tx = ses.beginTransaction();
		
	
	
	 // To insert 
		
		Book b = new Book(101,"Art of being alone ",200);
		
		ses.save(b);
		
		Book b1 = new Book(102,"Annamayya keerthana",500);
		ses.save(b1);
	

		
		
		// save
		
	//	Book b = new Book(102,"Annamayya keerthana",500);
		
	//	ses.save(b);
		
		//update
		
		//ses.update(p);


		
		// delete
		/*
		Book b = new Book(1,"oppo",500);
		 ses.delete(b);
		
		
		Book b = new Book(102,"art of being alone",500);
		 ses.delete(b);
		 
		 */
		//load 
		
		//commit transaction
		
		tx.commit();
		
		//close objects in reverse
		
		ses.close();
		factory.close();
		
		
		
	}

}
