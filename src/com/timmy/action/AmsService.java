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

	

	public Code CheckLogin(String username, String password) {
            		
	User user= amsDao.CheckLogin(username,password);
	 Code code=new Code();
     if(user==null)
     {
  	   code.setCode(0);
  	   code.setResult("失败");
     }else {
  	   if(password.equals(user.getPassword()))
  	   {
  		   code.setCode(1);
  		   code.setResult("成功");
  	   }else{
  		   code.setCode(0);
  		   code.setResult("失败");
  	   }
  	   
	}
     return code;
	}

	public List<User> getuserlist() {
		
		List<User> list=amsDao.getuserlist();
		return list;
	}

	public void register(User user) {
         amsDao.register(user);		
	}

}
