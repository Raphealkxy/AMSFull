package com.timmy.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class faceUtils {
            //探测图片中人脸
	public static void faceRecognize(AipFace client,String imagePath) {
	    // 自定义参数定义
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("max_face_num", "1");
	    options.put("face_fields", "expression");

	    // 参数为本地图片路径
	    //String imagePath = "face.jpg";
	    JSONObject response = client.detect(imagePath, options);
	    System.out.println(response.toString());

	    // 参数为本地图片文件二进制数组
//	    byte[] file = readImageFile(imagePath);
//	    JSONObject response = client.detect(file, options);
//	    System.out.println(response.toString());

	
	}
	//举例，要计算一张图片与指定组group1, group2内各用户相似度：

	public static JSONObject identifyUser(AipFace client,String path,String groupname) {
	    //String path = "test1.jpg";
	    HashMap<String, Object> options = new HashMap<String, Object>(1);
	    options.put("user_top_num", 1);
	    JSONObject res = client.identifyUser(Arrays.asList(groupname), path, options);
	   // System.out.println(res.toString(2));
	    return res;
	}
	
	//对一系列图片进行对比，图片路径装入一个数组中去
	public static void multiFaceComparison(AipFace client,String imagepath1,String imagepath2) {
	    // 参数为本地图片路径
	    String imagePath1 = imagepath1;
	    String imagePath2 = imagepath2;
	    ArrayList<String> pathArray = new ArrayList<String>();
	    pathArray.add(imagePath1);
	    pathArray.add(imagePath2);
	    JSONObject response = client.match(pathArray, new HashMap<String, String>());
	    System.out.println(response.toString());
	}
   //注册用户
	public static JSONObject facesetAddUser(AipFace client,String imagepath,String userID,String username,String groupname) {
	    // 参数为本地图片路径
	   // String path = "picture1.jpg";
	    HashMap<String, String> options = new HashMap<String, String>();
	    JSONObject res = client.addUser(userID, username, Arrays.asList(groupname), imagepath, options);
	  //  System.out.println(res.toString(2));
	    return res;
	    
	}
	//更新用户
	public static void facesetUpdateUser(AipFace client,String imagepath,String uid,String groupname) {
	    // 参数为本地图片路径
	    //String path = "picture1.jpg";
	    HashMap<String, String> options = new HashMap<String, String>();
	    JSONObject res = client.updateUser(uid, "user_info_memo", groupname, imagepath, options);
	    System.out.println(res.toString(2));
	}
	
	//从人脸库中删除一个用户
	public static  void facesetDeleteUser(AipFace client,String user,String groupname) {
	    // 只从指定组中删除用户
	    JSONObject res = client.deleteUser(user, Arrays.asList(groupname));
	    System.out.println(res.toString(2));

	    // 从人脸库中彻底删除用户
	    JSONObject res1 = client.deleteUser(user);
	    System.out.println(res1.toString(2));
	}
	//查看指定用户信息
	public static void getUser(AipFace client,String user,String groupname) {
	    // 查询一个用户在所有组内的信息
	    JSONObject res = client.getUser(user);
	    System.out.println(res.toString(2));

	    // 查询一个用户在指定组内的信息
	    JSONObject res2 = client.getUser(user, Arrays.asList(groupname));
	    System.out.println(res2.toString(2));
	}
	
	//查询用户组列表
	public static void getGroupList(AipFace client) {
	    HashMap<String, Object> options = new HashMap<String, Object>(2);
	    options.put("start", 0);
	    options.put("num", 10);
	    JSONObject res = client.getGroupList(options);
	    System.out.println(res.toString(2));
	}
	
	//用于查询指定用户组中的用户列表。
	public static void getGroupUsers(AipFace client,String groupname) {
	    HashMap<String, Object> options = new HashMap<String, Object>(2);
	    options.put("start", 0);
	    options.put("num", 10);
	    JSONObject res = client.getGroupUsers(groupname, options);
	    System.out.println(res.toString(2));
	}
	//用于将已经存在于人脸库中的用户添加到一个新的组。说明：并不是向一个指定组内添加用户，而是直接从其它组复制用户信息
	public static void addGroupUser(AipFace client) {
	    JSONObject res = client.addGroupUser("srcgroup", Arrays.asList("dstGroup1", "dstGroup2"), "uid1");
	    System.out.println(res.toString(2));
	}
	//用于将用户从某个组中删除，但不会删除用户在其它组的信息。说明：当用户仅属于单个分组时，本接口将返回错误，请使用人脸删除接口
	public static void deleteGroupUser(AipFace client) {
	    JSONObject res = client.deleteGroupUser(Arrays.asList("group1", "group2"), "uid1");
	    System.out.println(res.toString(2));
	}
	
}
