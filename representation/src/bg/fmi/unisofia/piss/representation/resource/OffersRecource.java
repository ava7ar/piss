package bg.fmi.unisofia.piss.representation.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import bg.fmi.unisofia.piss.appframework.core.Offers;
import bg.fmi.unisofia.piss.appframework.core.DatabasePersister;


@Path(value = "/offers")
public class OffersRecource {

	@GET
	@Path(value = "/add")
public Response offer (
        @PathParam(value="title") String title,
        @PathParam(value="description") String description,
        @PathParam(value="destination") String destination,
        @PathParam(value="price") double price,
        @PathParam(value="startDate") String startDate,
        @PathParam(value="endDate") String endDate,
        @PathParam(value="imageUrl") String imageUrl)         
	 {
             try{
            Offers offer = new Offers();
            offer.setTitle(title);
            offer.setDescription(description);
            offer.setPrice(price);
            offer.setStartDate(startDate);
            offer.setEndDate(endDate);
            offer.setStartDate(startDate);
            offer.setDestination(destination);
            offer.setImageUrl(imageUrl);
            DatabasePersister.persist(offer);
             }catch(RuntimeException e){
                 throw e;
             }
	}
             
}

