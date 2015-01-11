package bg.fmi.unisofia.piss.appframework.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DatabasePersister {

	private static SessionFactory factory;
	
	public static void persist(Persistable object) {
		factory = new AnnotationConfiguration().configure().addAnnotatedClass(object.getClass()).buildSessionFactory();
		
		Session session = factory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} finally {
			session.close();
		}
	}
}
