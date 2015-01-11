package bg.fmi.unisofia.piss.representation.resource;

import javax.jws.WebService;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import bg.fmi.unisofia.piss.appframework.core.DummyBean;
import bg.fmi.unisofia.piss.appframework.core.DatabasePersister;

@WebService
@Path(value = "/test")
public class DummyResource {

	@GET
	@Path(value = "/sample")
	@Produces(MediaType.APPLICATION_JSON)
	public String sample() {
            
            
		return "Kur";
	}
	
	@GET
	@Path(value = "hibernate")
	public String transaction() {
		DummyBean db = new DummyBean();
		db.setDummyName("asd");
		db.setDummyValue("kur");
		db.setId(123);
		DatabasePersister.persist(db);
		return "Successful";
	}


}
