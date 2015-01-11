package bg.fmi.unisofia.piss.representation.resource;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import bg.fmi.unisofia.piss.appframework.core;

@WebService
@Path(value = "/offers")
public class OffersRecource {

	@GET
	@Path(value = "/add")
	@Produces(MediaType.APPLICATION_JSON)
        
	public String add() {
         Offers addOffer = new Offers();
	}
}

