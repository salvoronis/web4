package com.jaxrs.anime;

import java.util.ArrayList;
import com.jaxrs.ejb.PointEJB;
import java.lang.Math;
import com.jaxrs.models.Point;
import javax.ejb.EJB;

public class Distance implements DistanceMBean{
	@EJB
	PointEJB pointEJB;
	public double averangeDistance(){
		ArrayList<Point> list = (ArrayList<Point>)pointEJB.getList();
		ArrayList<Double> results = new ArrayList<Double>();
		double sleep = 0;
		for (int i = 0;i<list.size();i++) {
			for (int j = i+1;j<list.size()-1;j++) {
				sleep = Math.sqrt(Math.pow(list.get(j).getX()-list.get(i).getX(),2.0)+Math.pow(list.get(j).getY()-list.get(i).getY(),2.0));
				results.add(sleep);
			}
		}
		double sum = 0;
		for (int i = 0;i<results.size();i++) {
			sum += results.get(i);
		}
		return sum/results.size();
	}
}