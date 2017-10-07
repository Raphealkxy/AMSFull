package com.timmy.test;

import java.util.List;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.google.gson.Gson;
import com.timmy.jsonEntity.IdentifyUserResult;
import com.timmy.jsonEntity.Result;
import com.timmy.utils.Connection;
import com.timmy.utils.faceUtils;

public class Test {

	public static void main(String[] args) {
		
		AipFace client=Connection.getConnection();
		String imgsrc="C:\\Users\\Timmy\\Pictures\\Camera Roll\\c10.jpg";
		String imgsrc1="D:\\output\\23.jpg";
	//	faceUtils.faceRecognize(client, imgsrc); 
     //   faceUtils.multiFaceComparison(client, imgsrc, imgsrc1);
	//	faceUtils.facesetDeleteUser(client, "15416115","group1");
     //   faceUtils.getGroupUsers(client,"group1");
		//faceUtils.getGroupList(client);
		//faceUtils.facesetAddUser(client, imgsrc1, "15416115", "杭登极", "group4");
//		faceUtils.getGroupList(client);
	  // faceUtils.getGroupUsers(client,"group4");
		JSONObject  resJsonObject=faceUtils.identifyUser(client, imgsrc1, "group4");
		Gson gson =new Gson();
		IdentifyUserResult identifyUserResult=gson.fromJson(resJsonObject.toString(2), IdentifyUserResult.class);
		List<Result> results=identifyUserResult.getResult();
		Result result=results.get(0);
		System.out.println(result.getUid());
		System.out.println(result.getScores());
     

	}

}
