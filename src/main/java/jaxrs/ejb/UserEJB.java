package com.jaxrs.ejb;

import com.jaxrs.models.User;
import org.hibernate.*;
import javax.persistence.Persistence;
import java.util.List;
import com.jaxrs.hibernate.HibernateUtil;
import javax.ejb.Stateless;

@Stateless
public class UserEJB{
	public static Long add(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Object result = session.save(user);
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
		return new Long(123);
	}
	public static User getByLogin(String login){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from User where login = :login");
		query.setParameter("login", login);
		List<User> list = query.list();
		session.close();
        return list.get(0);
	}
	public static void update(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
}