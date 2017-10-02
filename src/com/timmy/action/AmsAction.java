package com.timmy.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;






import com.baidu.aip.face.AipFace;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.timmy.DbEntity.Code;
import com.timmy.dao.User;
import com.timmy.utils.Connection;
import com.timmy.utils.faceUtils;

public class AmsAction extends ActionSupport{
	
	private AmsService amsService;
	private String username;
	private String password;
	private String id;
	private String sex;
	private String email;
	private String telphone;
	private String newpassword;
	private Code code;
	//上传文件必须
	//struts2会自动封装下面三个参数.文件名称和描述在这里就不做封装了!  
    //注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件  
    private File upload;//动作类上传的属性必须是file类型,upload为表单的name值  
    private String uploadFileName; //上传的文件名称,固定写法:name+FileName;  
    private String uploadContentType; //上传文件的mime类型,固定写法: name+ContextType;  
    private String ID;
    
    
    

	public String getNewpassword() {
		return newpassword;
	}



	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}



	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public File getUpload() {
		return upload;
	}



	public void setUpload(File upload) {
		this.upload = upload;
	}



	public String getUploadFileName() {
		return uploadFileName;
	}



	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}



	public String getUploadContentType() {
		return uploadContentType;
	}



	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAmsService(AmsService amsService) {
		this.amsService = amsService;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelphone() {
		return telphone;
	}



	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}



	public AmsService getAmsService() {
		return amsService;
	}


	@Override
	public String execute() throws Exception {
		return "ok";
	}

   public String UpdatePassword()
   {
	   Code code=amsService.UpdatePassword(username,newpassword);
	   System.out.println(1);
	   HttpServletResponse response=ServletActionContext.getResponse();
		  response.setContentType("application/json; charset=utf-8");  
      response.setCharacterEncoding("UTF-8");  
      Gson gson = new Gson();
      String result = gson.toJson(code);  
      OutputStream out1;
    
		try {
			 
			out1 = response.getOutputStream();
			 out1.write(result.getBytes("UTF-8"));  
	           out1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   
	   return NONE;
   }
	
	public String CheckLogin()
	{
		  //   System.out.println(username);
	    Code code=amsService.CheckLogin(username,password);
	     HttpServletResponse  response=ServletActionContext.getResponse();
	     HttpServletRequest request=ServletActionContext.getRequest();
	    response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");  
        Gson gson = new Gson();
        String result = gson.toJson(code);  
        OutputStream out;
		try {
			out = response.getOutputStream();
			 out.write(result.getBytes("UTF-8"));  
		        out.flush();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       
		return NONE;
	}
	
	//获取表单数据
	public String getuserlist()
	{
		System.out.println(username);
		List<User> list=new ArrayList<User>();

		list=amsService.getuserlist();
		//System.out.println(list.size());
	     HttpServletResponse  response=ServletActionContext.getResponse();

	        Gson gson = new Gson();
	        String result = gson.toJson(list);  

	
	

         response.setContentType("application/json; charset=utf-8");  
         response.setCharacterEncoding("UTF-8");  

     
         OutputStream out;
		try {
			out = response.getOutputStream();
			out.write(result.getBytes("UTF-8"));  
	         out.flush();  
		} catch (IOException e) {
			e.printStackTrace();
		}  
         
		
		return NONE;
	}
	
	public String getdata()
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println(sex);
		System.out.println(telphone);
		System.out.println(email);
        System.err.println(id);
        String telephone=telphone;
		User user=new User();
		//	user.setUid(uid);
			user.setEmail(email);
			user.setPassword(password);
			user.setTelephone(telephone);
			user.setUsername(username);
			user.setSex(sex);
			user.setUserNumber(id);
		int i=amsService.register(user);
		if(i>=0)
		{
			 code=new Code();
			code.setCode(2);
			code.setResult("基本信息注册成功");
		}else{
		     code=new Code();
		code.setCode(3);
		code.setResult("基本注册失败");
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
		  response.setContentType("application/json; charset=utf-8");  
         response.setCharacterEncoding("UTF-8");  
         Gson gson = new Gson();
         String result = gson.toJson(code);  
         OutputStream out1;
       
		try {
			 
			out1 = response.getOutputStream();
			 out1.write(result.getBytes("UTF-8"));  
	           out1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return NONE;
	}

	public String upload()
	{
		// 我们需要做的就是提供一个服务器的存放地址即可
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/upload");
		// 判断路径是否存在,不存在创建
		File dir = new File(realPath);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		// 第一个参数是文件 ,第二个参数是文件在服务器中的位置,fileUtils
		// 是org.apache.commons.io.FileUtils提供好的现成的方法
		// FileUtils.copyFile(upload,new
		// File(dir,uploadFileName));//copy文件,服务器中有备份文件
		try {
			FileUtils.moveFile(upload, new File(dir, uploadFileName));// 剪切文件,推荐使用,无备份文件
			System.out.println("file upload success.....");
		} catch (Exception e) {
			e.printStackTrace();

		}
		String picpath=dir+"\\"+uploadFileName;
		System.out.println(picpath);
		AipFace client=Connection.getConnection();
		org.json.JSONObject res=faceUtils.facesetAddUser(client, picpath, ID, username);
		   System.out.println(res.toString(2));
			Long log_id=res.getLong("log_id");
			System.out.println(log_id);
			if(log_id!=null)
			{
				 code=new Code();
				code.setCode(2);
				code.setResult("人脸注册成功");
			}else{
			     code=new Code();
			code.setCode(3);
			code.setResult("人脸注册失败");
			}
			
		HttpServletResponse response=ServletActionContext.getResponse();
			  response.setContentType("application/json; charset=utf-8");  
	           response.setCharacterEncoding("UTF-8");  
	           Gson gson = new Gson();
	           String result = gson.toJson(code);  
	           OutputStream out1;
	         
			try {
				 
				out1 = response.getOutputStream();
				 out1.write(result.getBytes("UTF-8"));  
		           out1.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	           
		return NONE;
	}


			
	
}
