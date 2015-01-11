package bg.fmi.unisofia.piss.representation.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import bg.fmi.unisofia.piss.appframework.core.DatabasePersister;
import bg.fmi.unisofia.piss.appframework.core.UserAccount;
import bg.fmi.unisofia.piss.appframework.core.Utils;

@Path(value = "register")
public class AccountResource {

	@GET
	@Path(value = "{username}/{password}/{email}")
	public Response register(@PathParam(value = "username") String username, @PathParam(value = "password")
		String password, @PathParam(value = "email") String email) {
		try {
			if (Utils.validateAccountData(username, email, this.getClass())) {
				UserAccount user = new UserAccount();
				user.setEmail(email);
				user.setId();
				user.setUsername(username);
				user.setPassword(password);
				DatabasePersister.persist(user);
				return Response.status(200).build();
			} else {
				return Response.status(301).build();
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
