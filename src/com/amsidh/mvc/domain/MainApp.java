package com.amsidh.mvc.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {

	public static void main(String[] args) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		SessionFactory sessionFactory=configure.buildSessionFactory(serviceRegistry);
		UserDetails user=new UserDetails();
		
		
		//transient state
		user.setUserId(123);
		user.setUserName("Amsidh Lokhande");
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		//persistent state
		user.setUserName("UserName after save call");
		user.setUserName("UserName after save call2");
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		
		
		
		
		//user.setUserName("Name set after session close");
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		
		
		user.setUserName("Change name for checking merge call");
		
		
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user1=(UserDetails) session.get(UserDetails.class,123);
		user1.setUserName("Need merge here");
		session.merge(user);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0;i<10; i++){
			UserDetails u=new UserDetails();
			u.setUserId(i);
			u.setUserName("UserName "+i);
			session.save(u);
		}
		
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		sessionFactory.close();
		
		
		
	}

}
