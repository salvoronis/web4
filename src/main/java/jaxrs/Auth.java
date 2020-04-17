package com.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.jaxrs.models.User;
import com.jaxrs.managers.UserManager;
import org.apache.commons.codec.digest.DigestUtils;

@Path("/auth")
public class Auth {
	@POST
	@Path("/auth")
	@Consumes("application/json")
	@Produces("application/json")
	public User auth(User user){
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        Long result = UserManager.add(user);
        System.out.println(result);
		return user;
	}
}