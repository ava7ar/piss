package bg.fmi.unisofia.piss.representation.resource;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Path(value = "/test")
public class DummyResource {

	@GET
	@Path(value = "/sample")
	@Produces(MediaType.APPLICATION_JSON)
	public String sample() {
            
            
		return "Kur";
	}
}
