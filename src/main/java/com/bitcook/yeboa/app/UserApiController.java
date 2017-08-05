package com.bitcook.yeboa.app;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.models.User;
import com.bitcook.yeboa.app.services.SecurityService;
import com.bitcook.yeboa.app.utils.PasswordUtils;

@Path("/users")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class UserApiController {

	// ======================================
	// = Injection Points =
	// ======================================

	@Context
	private UriInfo uriInfo;

	@Autowired
	private SecurityService securityService;

	@POST
	@Path("/login")
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("login") String login, @FormParam("password") String password) {

		try {

			// Authenticate the user using the credentials provided
			securityService.authenticate(login, password);

			// Issue a token for the user
			String token = PasswordUtils.issueToken(login, uriInfo.getAbsolutePath().toString());

			// Return the token on the response
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
	}

	@POST
	@Path("/register")
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String name,@FormParam("msisdn") String number, @FormParam("email") String email ,@FormParam("password") String password) {
		User user = new User();
		securityService.saveUser(user);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getId().toString()).build()).build();
	}

}
