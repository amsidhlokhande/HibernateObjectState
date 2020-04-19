package com.amsidh.mvc.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.service.ServiceRegistry;

public class NamedQueryMainApp {

	public static void main(String[] args) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties())
				.build();
		SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*Query hqlQuery = session.getNamedQuery("getUserDetails.ByUserId");
		hqlQuery.setInteger("userId", 5);
		List<UserDetails> userDetails = hqlQuery.list();
		for (UserDetails userDetail : userDetails) {
			System.out.println(userDetail.getUserId() + "      " + userDetail.getUserName());
		}

		Query sqlQuery = session.getNamedQuery("getUser.ByUserName");
		sqlQuery.setString("userName", "UserName-%");
		userDetails = sqlQuery.list();
		for (UserDetails userDetail : userDetails) {
			System.out.println(userDetail.getUserId() + "      " + userDetail.getUserName());
		}*/
		
		/*Query sqlQuery = session.getNamedQuery("byUserName");
		sqlQuery.setInteger("userId", 8);
		List<UserDetails> userDetails = sqlQuery.list();
		for (UserDetails userDetail : userDetails) {
			System.out.println(userDetail.getUserId() + "      " + userDetail.getUserName());
		}
        */
		
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(new Criterion[]{Restrictions.eq("userId", 9),Restrictions.between("userId", 2, 5),Restrictions.like("userName", "UserName-1%")}));
		List<UserDetails> userDetails = criteria.list();
		for (UserDetails userDetail : userDetails) {
			System.out.println(userDetail.getUserId() + "      " + userDetail.getUserName());
		}*/
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.max("userId"));
		Integer uniqueResult = (Integer) criteria.uniqueResult();
		System.out.println(uniqueResult);
		*/
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.sum("userId"));
		Integer uniqueResult =  ((Long)criteria.uniqueResult()).intValue();
		System.out.println(uniqueResult);*/
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.avg("userId"));
		Integer uniqueResult =  ((Double)criteria.uniqueResult()).intValue();
		System.out.println(uniqueResult);
		*/
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.rowCount());
		Integer uniqueResult =  ((Long)criteria.uniqueResult()).intValue();
		System.out.println(uniqueResult);*/
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.property("userName"));
		List<String> uniqueResult =  criteria.list();
		for (String string : uniqueResult) {
			System.out.println(string);
		}
		*/
		

        /*UserDetails userDetails=new UserDetails();
        //userDetails.setUserId(5);
        userDetails.setUserName("UserName-10");
        Example example=Example.create(userDetails);
        Criteria criteria = session.createCriteria(UserDetails.class).add(example);
        
		List<UserDetails> uniqueResult =  criteria.list();
		for (UserDetails user : uniqueResult) {
			System.out.println(user.getUserId() +"     "+user.getUserName());
		}*/
		
		
		 UserDetails userDetails=new UserDetails();
	        //userDetails.setUserId(5);
	        userDetails.setUserName("UserName-1%");
	        Example example=Example.create(userDetails).enableLike();
	        Criteria criteria = session.createCriteria(UserDetails.class).add(example);
	        
			List<UserDetails> uniqueResult =  criteria.list();
			for (UserDetails user : uniqueResult) {
				System.out.println(user.getUserId() +"     "+user.getUserName());
			}

			

			

        /*UserDetails userDetails=new UserDetails();
        //userDetails.setUserId(5);
        userDetails.setUserName("UserName-10");
        Example example=Example.create(userDetails).excludeProperty("userName");
        Criteria criteria = session.createCriteria(UserDetails.class).add(example);
        
		List<UserDetails> uniqueResult =  criteria.list();
		for (UserDetails user : uniqueResult) {
			System.out.println(user.getUserId() +"     "+user.getUserName());
		}*/

		
		
		
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		sessionFactory.close();

	}

}
