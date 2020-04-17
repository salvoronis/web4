package com.jaxrs.managers;

import com.jaxrs.models.User;
import org.hibernate.Session;
import org.hibernate.Hibernate;

public class UserManager {
	public static Long add(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long result = (Long) session.save(user);
        session.getTransaction().commit();
		return result;
	}
}