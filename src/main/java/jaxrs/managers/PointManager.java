package com.jaxrs.managers;

import com.jaxrs.models.Point;
import org.hibernate.*;
import javax.persistence.Persistence;
import java.util.List;

public class PointManager {
	public static Long add(Point point){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
        session.close();
		return new Long(123);
	}

	public static List<Point> getList(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Point> result = session.createQuery("from Point order by id").list();
        session.getTransaction().commit();
        session.close();
        return result;
	}
}