package com.jaxrs.anime;

import com.jaxrs.managers.PointManager;
import com.jaxrs.models.Point;
import java.util.List;
import java.util.Collections;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;


public class Laba extends NotificationBroadcasterSupport implements LabaMBean {
	private int seq = 0;
	private int counter = 0;
	public int getUsersDotNumb(String user){
		return PointManager.getDotsNumb(user);
	}
	public int correctDots(){
		return PointManager.getResNumb("Y");
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