package com.timmy.utils;

import com.baidu.aip.face.AipFace;

public class Connection {
	 //设置APPID/AK/SK
    public static final String APP_ID = "9887914";
    public static final String API_KEY = "GovfekLw88f1eWFwLOzPerQq";
    public static final String SECRET_KEY = "ZPoZ9oYM8l98LLv145wY157UkNbqIfeD";
    public static AipFace getConnection()
    {
    	
    	
    	return new AipFace(APP_ID, API_KEY, SECRET_KEY);
    }
}
