package cn.tycoding.entity;

import java.util.Date;

public class News {
	  private Long id; //编号
	    private String title; //音乐名
	    private String content; //收听人数
	    private String img; //商品图片
	    private Date new_date;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public Date getNew_date() {
			return new_date;
		}
		public void setNew_date(Date new_date) {
			this.new_date = new_date;
		}
		
}
