﻿##  音乐网站
### 技术
- springboot
- mysql
- vue
- element-ui
### 登录注册功能
- 游客
- 用户
- 管理员
### 后台管理模块
- 新闻管理
- 音乐管理
- 用户管理
### 在线收听
- 下载
- 试听
- 留言
### 截图
1. 网站主页

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214222758490-2001744455.png)

2. 歌曲收听

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214222945153-271075496.png)

3. 登录注册
![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214223201683-1527725939.png)

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214223216781-1020692538.png)
3. 后台管理
![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214224016273-357408686.png)

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214224106893-887168475.png)

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190214224112774-1590198725.png)

---
更新：
1. 新闻添加失败解决：将news表的id设置为自动增长；newsmapper.xml日期修改成now();新闻图片添加可以显示了。

```
<insert id="create" parameterType="cn.tycoding.entity.News">
        INSERT INTO news(title, content, img, new_date)
        VALUES(#{title}, #{content}, #{img}, now())
</insert>
```

![](https://img2018.cnblogs.com/blog/1555913/201902/1555913-20190215083348597-1823207209.png)
2. 音乐可以添加，图片也可以了
通过配置页面映射

```
public class UploadFileConfig extends WebMvcConfigurationSupport{

	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/Users/Administrator/AppData/Local/Temp/tomcat-docbase.8476537028754118257.8080/upload/");
	        super.addResourceHandlers(registry);
	    }

}
```
