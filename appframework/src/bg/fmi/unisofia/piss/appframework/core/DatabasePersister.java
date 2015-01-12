package bg.fmi.unisofia.piss.appframework.core;

import org.hibernate.*;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;

public class DatabasePersister {

    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        DatabasePersister.factory = factory;
    }

    public DatabasePersister() {
        factory = new AnnotationConfiguration().configure().addAnnotatedClass(object.getClass()).buildSessionFactory();

    }

    public static void persist(Persistable object) {

        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            if (object.getId() != null) {
                session.update(object);
            } else {
                session.save(object);
            }
            tx.commit();
        } finally {
            session.close();
        }
    }
}
