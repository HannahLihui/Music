package cn.tycoding.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	  long id;
      Date date; //评论时间
      long ownerId ;//文章的id
      long fromId;//评论者id
      String fromName;  //评论者昵称
      String fromAvatar;
      int likeNum; //点赞人数
      String content;  //评论内容
      String reply;
      public Message() {
    	  
      }
  
	public Message(long ownerId, String content,String fromName) {
		// TODO Auto-generated constructor stub
		this.ownerId=ownerId;
		this.content=content;
		likeNum=0;
		this.fromName=fromName;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public long getFromId() {
		return fromId;
	}
	public void setFromId(long fromId) {
		this.fromId = fromId;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getFromAvatar() {
		return fromAvatar;
	}
	public void setFromAvatar(String fromAvatar) {
		this.fromAvatar = fromAvatar;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	

}
