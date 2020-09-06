package aforo255.security.jwt;

import java.util.HashMap;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import aforo255.security.jwt.service.TokenService;

@Path("/profile")
public class ProfileResource {

	@Inject
	TokenService service ;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		
		return "Mi nombres es Stywar  Vargas chino ";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public HashMap<String, String> getToken(@QueryParam("username") String username ,
			@QueryParam("password") String password )
	{
		//Tarea para el proximo Domingo 13 Setiembre
		String email="ObtenerBD";		
		final String token = service.generateToken(username, email);
		
		return new HashMap<String, String>() {{
			put ("token",token);
			
		}};
		
		
	}
	
	

	
}
