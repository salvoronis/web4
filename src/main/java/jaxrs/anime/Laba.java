package com.jaxrs.anime;

import com.jaxrs.ejb.PointEJB;
import com.jaxrs.models.Point;
import java.util.List;
import java.util.Collections;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.ejb.EJB;


public class Laba extends NotificationBroadcasterSupport implements LabaMBean {
	@EJB
	PointEJB pointEJB;
	private int seq = 0;
	private int counter = 0;
	public int getUsersDotNumb(String user){
		return pointEJB.getDotsNumb(user);
	}
	public int correctDots(){
		return pointEJB.getResNumb("Y");
	}
	public void addPoint(double x,double y,double r){
		Point point = new Point(x,y,r);
		point.solve();
		if (point.getResult().equals("N")) {
			counter++;
		}
		if (counter%2==0) {
			sendNotification(new Notification("2_error",this,seq++,System.currentTimeMillis(),"user have 2 errors"));			
		}
	}
}