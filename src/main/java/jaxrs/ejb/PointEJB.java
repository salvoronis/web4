package com.jaxrs.ejb;

import com.jaxrs.models.Point;
import org.hibernate.*;
import javax.persistence.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import com.jaxrs.hibernate.HibernateUtil;

@Stateless
public class PointEJB{
	public Long add(Point point){
		Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(point);
                session.getTransaction().commit();
                session.close();
		return new Long(123);
	}

	public List<Point> getList(){
		Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                List<Point> result = session.createQuery("from Point order by id").list();
                session.getTransaction().commit();
                session.close();
                return result;
	}
        public int getDotsNumb(String login){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("select count(*) from Point where login = :login");
                query.setString("login",login);
                Long result = (Long)query.uniqueResult();
                int res = result.intValue();
                return res;
        }
        public int getResNumb(String val){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("select count(*) from Point where result = :val");
                query.setString("val",val);
                Long result = (Long)query.uniqueResult();
                int res = result.intValue();
                return res;
        }
}