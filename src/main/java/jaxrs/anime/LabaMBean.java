package com.jaxrs.anime;

import com.jaxrs.models.Point;

public interface LabaMBean {
	int getUsersDotNumb(String user);
	int correctDots();
	void addPoint(double x,double y,double r);
}