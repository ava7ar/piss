package bg.fmi.unisofia.piss.appframework.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Utils {

	private static SessionFactory factory = null;
	
	public static boolean validateAccountData(String username, String email, Class clazz) {
//		init(clazz);
//		try {
//			Session session = factory.openSession();
//			session.beginTransaction();
//			try {
//			Query query = session.createQuery("select * from Users where name = username and email = email");
//			List result = query.list();
//			if (result.isEmpty()) {
//				return true;
//			} else {
//				return false;
//			}
//			} finally {
//				session.close();
//			} 
//		} catch (RuntimeException e) {
//			throw e;
//			//Do nothing for now;
//		}
		return true;
	}
	private static void init(Class clazz) {
		factory = new AnnotationConfiguration().configure().addAnnotatedClass(getBean(clazz)).buildSessionFactory();
	}
	private static Class getBean(Class clazz) {
		if (clazz.getName().equals("AccountResource")) {
			return UserAccount.class;
		}
		
		return null;
	}
}
