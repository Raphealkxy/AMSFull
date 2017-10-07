package com.timmy.jsonEntity;
import java.util.List;

/**
 * Auto-generated: 2017-10-07 15:29:31
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Result {

    private String userInfo;
    private String uid;
    private List<Double> scores;
    private String groupId;
    public void setUserInfo(String userInfo) {
         this.userInfo = userInfo;
     }
     public String getUserInfo() {
         return userInfo;
     }

    public void setUid(String uid) {
         this.uid = uid;
     }
     public String getUid() {
         return uid;
     }

    public void setScores(List<Double> scores) {
         this.scores = scores;
     }
     public List<Double> getScores() {
         return scores;
     }

    public void setGroupId(String groupId) {
         this.groupId = groupId;
     }
     public String getGroupId() {
         return groupId;
     }

}