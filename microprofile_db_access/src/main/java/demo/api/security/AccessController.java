package demo.api.security;

import java.util.Arrays;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import demo.api.dto.BenutzerLoginDto;
import demo.dao.UserDAO;
import demo.model.User;
import demo.util.PasswordTools;


@Path("/access")
@Singleton
public class AccessController
{
   @Inject
   AccessManager accessManager;

   @Inject
   UserDAO userManager;

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response login(BenutzerLoginDto user)
   {     
      System.out.println("Login User " + user.getUsername() );
      try
      {
         User optUser = this.userManager.readUser(user.getUsername());
         
         if( optUser!= null )
         {
            //Check Password
            if( !Arrays.equals(PasswordTools.generatePasswordHash(user.getPassword(), optUser.getPasswordSalt()),( optUser.getPasswordHash() )))
            {
               System.err.println("Wrong Password");
               throw new RuntimeException("Wrong Password");
            }
            
            //Login
            UUID uuid = this.accessManager.login(user.getUsername());
            LoginToken token = new LoginToken( uuid.toString() ); 
            return Response.ok().entity(token).build();
         }
         else
         {
            System.err.println("User " + user.getUsername() + " not known");
            throw new RuntimeException("User not known");
         }
      }
      catch (Exception exce)
      {
         System.out.println("ERROR " + exce.getMessage() );
         return Response.status(404).build();
      }
   }
   
   @DELETE
   public Response logout(@HeaderParam("token") String loginToken)
   {
      try
      {
         System.out.println("Logout: " + this.accessManager.getLoginName(UUID.fromString(loginToken)));
         
         this.accessManager.logout( UUID.fromString(loginToken) );
         return Response.ok().build();
      }
      catch (Exception exce)
      {
         System.out.println("ERROR " + exce.getMessage() );
         return Response.status(404).build();
      }
   }
}
