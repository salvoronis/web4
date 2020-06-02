package com.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.jaxrs.models.User;
import com.jaxrs.models.Point;
import com.jaxrs.managers.UserManager;
import com.jaxrs.managers.PointManager;
import java.util.List;

@Path("/main")
public class MainPage {
	@GET
	@Path("/getPoints")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Point> getPoints(User user){
		boolean corToken = UserManager.getByLogin(user.getLogin()).getToken().equals(user.getToken()) || !UserManager.getByLogin(user.getLogin()).getToken().equals("");
		if (corToken){
			return PointManager.getList();
		}
		return null;
	}

	@POST
	@Path("/getPoints")
	@Consumes("application/json")
	@Produces("application/json")
	public Point addPoint(Point point){
		boolean corToken = UserManager.getByLogin(point.getLogin()).getToken().equals(point.getToken()) || !UserManager.getByLogin(point.getLogin()).getToken().equals("");
		if(corToken){
			point.solve();
			PointManager.add(point);
			return point;
		}
		return null;
	}

	@POST
	@Path("/exit")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean exit(User user){
		User userdb = UserManager.getByLogin(user.getLogin());
		userdb.setToken("");
		UserManager.update(userdb);
		return true;
	}
}
