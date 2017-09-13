package com.timmy.utils;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class Sample {

	
	 //设置APPID/AK/SK
    public static final String APP_ID = "9887914";
    public static final String API_KEY = "GovfekLw88f1eWFwLOzPerQq";
    public static final String SECRET_KEY = "ZPoZ9oYM8l98LLv145wY157UkNbqIfeD";
    
	public static void main(String[] args) {
		 // 初始化一个FaceClient
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用API
        String path = "C:\\Users\\Timmy\\Pictures\\Camera Roll\\c04.jpg";
        //JSONObject res = client.detect(path, new HashMap<String, String>());
        //System.out.println(res.toString(2));
      // Utils.facesetAddUser(client, path, "15416118", "孔祥月");
        //Utils.getGroupUsers(client);
        faceUtils.identifyUser(client,path);
	}

}
