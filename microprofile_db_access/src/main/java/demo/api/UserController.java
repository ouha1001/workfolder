package demo.api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import demo.api.dto.RegistrationData;
import demo.api.dto.UserResponseData;
import demo.dao.UserDAO;
import demo.model.User;


@Path("user")
public class UserController {

	@Inject
	private UserDAO userDAO;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(RegistrationData registrationData) {
		
		System.out.println();
		System.out.println("Register " + registrationData );
		
		final User createdUser = userDAO.createUser(registrationData);
		
	return Response.ok().entity(createdUser).build();
	}

	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("userId") int userId) {
		final User user = userDAO.readUser(userId);

		final UserResponseData userData = UserResponseData.fromEntity(user);

		return Response.ok().entity(userData).build();
	}
}
