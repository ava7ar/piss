/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.fmi.unisofia.piss.appframework.core;

//import java.time.Instant;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gloria
 */
public class OffersMain extends DatabasePersister {

    Session session;

    public OffersMain() {
        this.session = super.getFactory().openSession();
    }

    public boolean addOffer(String title, String description, String destination, double price,
            String startDate, String endDate, String imageUrl) {

        //add offer to db
        try {
            Offers offer = new Offers();
            offer.setTitle(title);
            offer.setDescription(description);
            offer.setPrice(price);
            offer.setStartDate(startDate);
            offer.setEndDate(endDate);
            offer.setStartDate(startDate);
            offer.setDestination(destination);
            offer.setImageUrl(imageUrl);
            persist(offer);
        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return true; //if it's ok 
    }

    //delete offer from id
    public void deleteOffer(int offerId) {

        try {
            Offers offer = (Offers) session.get(Offers.class, offerId);
            session.delete(offer);
        } catch (HibernateException e) {

            e.printStackTrace();
        }
    }

// when push button edit
    public Offers editOffer(int offerId) {

        //list one offer to edit
        try {
            Offers offer = (Offers) session.get(Offers.class, offerId);

        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return offer; //if it's ok 
    }

    public void editOffer(int offerId, String title, String destination, String description,
            double price, String startDate, String endDate, String imageUrl) {
        try {
            Offers offer = (Offers) session.get(Offers.class, offerId);
            offer.setTitle(title);
            offer.setDescription(description);
            offer.setPrice(price);
            offer.setStartDate(startDate);
            offer.setEndDate(endDate);
            offer.setStartDate(startDate);
            offer.setDestination(destination);
            offer.setImageUrl(imageUrl);
            persist(offer);
        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return offer;
    }

    public List listOffers() {
        List offers = new ArrayList();
        try {
            offers = session.createQuery("From Offers").list();
        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return offers;
    }

}
