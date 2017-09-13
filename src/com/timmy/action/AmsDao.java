package com.timmy.action;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.opensymphony.xwork2.ActionSupport;
import com.timmy.DbEntity.Code;
import com.timmy.dao.*;
public class AmsDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void test()
	{
		System.out.println("amsdao...............");
	}

	public User CheckLogin(String username, String password) {
	     User user=hibernateTemplate.get(User.class, username);
	     if(user!=null)
	     {
	    	 return user;
	     }else
		return null;
	}

	public List<User> getuserlist() {
		
		String hql="from User";
		
		List<User> list=(List<User>) hibernateTemplate.find(hql);
		if(list!=null){
			return list;
		}else
		  return null;
	}

	public void register(User user) {

		try {
			hibernateTemplate.save(user);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	
	
	

}
