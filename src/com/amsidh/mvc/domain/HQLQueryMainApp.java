package com.amsidh.mvc.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HQLQueryMainApp {

	public static void main(String[] args) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties())
				.build();
		SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		/*for(int i=1;i<=10;i++)
		{
			session.save(new UserDetails(i,"UserName-"+i));
		}
		
		session.flush();
		session.getTransaction().commit();*/
		
		/*Query query = session.createQuery("select user from UserDetails user where user.userId=9 or user.userName like '%0'");
		List<UserDetails> users = query.list();

		for (UserDetails user : users) {
			System.out.println(user.getUserId() + "  :" + user.getUserName());
		}
*/
		
		/*Query query = session.createQuery("from UserDetails");
		query.setFirstResult(6);
		query.setMaxResults(3);

		List<UserDetails> users = query.list();

		for (UserDetails user : users) {
			System.out.println(user.getUserId() + "  :" + user.getUserName());
		}*/
		
		/*Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(6);
		query.setMaxResults(3);

		List<String> userNamess = query.list();

		for (String userName : userNamess) {
			System.out.println(userName);
		}*/
		
		
		/*Query query = session.createQuery("select new map(userId,userName) from UserDetails");
		query.setFirstResult(6);
		query.setMaxResults(3);

		List<Map<Integer,String>> userList = query.list();

		for (Map map : userList) {
			Set<String> keySets = map.keySet();
			for(String key:keySets){
				System.out.print(map.get(key)+ "    ");
			}
			
			System.out.println();
		}*/
		
		
		Query query = session.createQuery("select new map(userId,userName) from UserDetails");
		query.setFirstResult(6);
		query.setMaxResults(3);

		List<Map<Integer,String>> userList = query.list();

		for (Map map : userList) {
			Set<String> keySets = map.keySet();
			for(String key:keySets){
				System.out.print(map.get(key)+ "    ");
			}
			
			System.out.println();
		}

		
		sessionFactory.close();

	}
}
