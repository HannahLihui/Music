package cn.tycoding.controller.admin;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class UploadFileConfig extends WebMvcConfigurationSupport{

	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/Users/Administrator/AppData/Local/Temp/tomcat-docbase.8476537028754118257.8080/upload/");
	        super.addResourceHandlers(registry);
	    }

}
