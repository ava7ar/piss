/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.fmi.unisofia.piss.appframework.core;

import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Gloria
 */
public class OffersMain {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new AnnotationConfiguration()
                    .configure()
                    .addAnnotatedClass(Offers.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Failed to create session" + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public boolean addOffer(String title, String description,double price, Date startDate, Date endDate) {
        Session session = factory.openSession();
        Transaction tx = null;
        
       //add offer to db
        try {
            tx = session.beginTransaction();
            Offers offer = new Offers();
            offer.setTitle(title);
            offer.setDescription(description);
            offer.setPrice(price);
            offer.setStartDate(startDate);
            offer.setEndDate(endDate);
            offer.setStartDate(Date.from(Instant.EPOCH));
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
        
        return true; //if it's ok 
    }
    //delete offer from id
    public void deleteOffer(int offerId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Offers offer = (Offers) session.get(Offers.class, offerId);
            session.delete(offer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
// when push button edit
    public void editOffer(int offerId) {

    }

    public void editOffer (int offerId, String title, String description,double price, Date startDate, Date endDate){
        
    }
    public List listOffers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List offers = new ArrayList();
        try {
            tx = session.beginTransaction();
            offers = session.createQuery("From Offers").list();
//            for (Iterator iterator = offers.iterator(); iterator.hasNext();) {
//                Offers offer = (Offers) iterator.next();
//                System.out.println("Title" + offer.getTitle());
//                System.out.println("Description" + offer.getDescription());
//                System.out.println("Price" + offer.getPrice());
//                System.out.println("Start Date" + offer.getStartDate());
//                System.out.println("End Date" + offer.getEndDate());
//            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return offers;
    }
}
