package com.jaxrs.anime;

import java.util.ArrayList;
import com.jaxrs.managers.PointManager;
import java.lang.Math;
import com.jaxrs.models.Point;

public class Distance implements DistanceMBean{
	public double averangeDistance(){
		ArrayList<Point> list = (ArrayList<Point>)PointManager.getList();
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