package com.timmy.action;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.timmy.DbEntity.Code;
import com.timmy.dao.User;

@Transactional
public class AmsService {
	
	
	private AmsDao amsDao;

	public void setAmsDao(AmsDao amsDao) {
		this.amsDao = amsDao;
	}
	
//	public void test()
//	{
//		System.out.println("amsservice.............");
//		amsDao.test();
//	}

	

	public User CheckLogin(String username, String password) {
            		
	User user= amsDao.CheckLogin(username,password);
	String pasString=user.getPassword();
	if(pasString.equals(password))
	{
		return user;
	}
//	 Code code=new Code();
//     if(user==null)
//     {
//  	   code.setCode(3);
//  	   code.setResult("失败");
//     }else {
//  	   if(password.equals(user.getPassword()))
//  	   {
//  		   code.setCode(2);
//  		   code.setResult("成功");
//  	   }else{
//  		   code.setCode(3);
//  		   code.setResult("失败");
//  	   }
//  	   
//	}
     return null;
	}

	public List<User> getuserlist() {
		
		List<User> list=amsDao.getuserlist();
		return list;
	}

	public int register(User user) {
       return  amsDao.register(user);		
	}

	public Code UpdatePassword(String username,
			String newpassword) {
		User user=amsDao.UpdatePassword(username,newpassword);
		 Code code=new Code();

		if(user.getPassword().equals(newpassword))
		{
			code.setCode(2);
	  		   code.setResult("成功");
		}else{
			 code.setCode(3);
	  		   code.setResult("失败");
		}
		return code;
	}

	public Code UpdateInfo(String username, String newusername,String telphone,String email) {
		User user=amsDao.UpdateInfo(username,newusername,telphone,email);
		 Code code=new Code();
		 if(user!=null)
			{
				code.setCode(2);
		  		   code.setResult("成功");
			}else{
				 code.setCode(3);
		  		   code.setResult("失败");
			}
			return code;
	}

}
