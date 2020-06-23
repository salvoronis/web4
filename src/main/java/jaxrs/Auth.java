package com.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.Produces;
import com.jaxrs.models.User;
import com.jaxrs.models.AnswerRegister;
import com.jaxrs.managers.UserManager;
import java.security.SecureRandom;

@Path("/auth")
public class Auth {
	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces("application/json")
	public AnswerRegister register(User user){
		try{
			SecureRandom random = new SecureRandom();
			byte bytes[] = new byte[20];
			random.nextBytes(bytes);
			user.setToken(bytes.toString());

        	Long result = UserManager.add(user);
        	AnswerRegister answer = new AnswerRegister(user.getToken(), true);
        	return answer;
    	} catch (Exception ex) {
    		return new AnswerRegister(false);
    	}
	}

	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public AnswerRegister login(User user){
		try{
			User dbuser = UserManager.getByLogin(user.getEmail());
			boolean correct = dbuser.getPassword().equals(user.getPassword());
			if (correct){
				SecureRandom random = new SecureRandom();
				byte bytes[] = new byte[20];
				random.nextBytes(bytes);
				String token = bytes.toString();
				dbuser.setToken(token);
				UserManager.update(dbuser);
				return new AnswerRegister(token, correct);
			} else {
				return new AnswerRegister(false);
			}
		} catch(Exception e){
			return new AnswerRegister(false);
		}
	}
}
