package com.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.jaxrs.models.User;
import com.jaxrs.models.Point;
import java.util.List;
import javax.ejb.EJB;
import com.jaxrs.ejb.*;

@Path("/main")
public class MainPage {
	@EJB
	PointEJB pointEJB;

	@EJB
	UserEJB userEJB;

	@GET
	@Path("/getPoints")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Point> getPoints(User user){
		boolean corToken = userEJB.getByLogin(user.getEmail()).getToken().equals(user.getToken()) && !userEJB.getByLogin(user.getEmail()).getToken().equals("anime");
		if (corToken){
			return pointEJB.getList();
		}
		return null;
	}

	@POST
	@Path("/getPoints")
	@Consumes("application/json")
	@Produces("application/json")
	public Point addPoint(Point point){
		boolean corToken = userEJB.getByLogin(point.getLogin()).getToken().equals(point.getToken()) && !userEJB.getByLogin(point.getLogin()).getToken().equals("anime");
		if(corToken){
			point.solve();
			pointEJB.add(point);
			return point;
		}
		return null;
	}

	@POST
	@Path("/exit")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean exit(User user){
		User userdb = userEJB.getByLogin(user.getEmail());
		userdb.setToken("anime");
		userEJB.update(userdb);
		return true;
	}
}
