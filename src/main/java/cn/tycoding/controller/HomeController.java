package cn.tycoding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 *
 * @auther TyCoding
 * @date 2018/9/28
 */
@Controller
public class HomeController {

    /**
     * 系统首页
     *
     * @return
     */
	 @GetMapping(value = {"/Userindex"})
	    public String Userindex() {
	        return "/Userindex";
	    }
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/youke";
    }

    /**
     * 商品列表页
     *
     * @return
     */
    @GetMapping(value = {"/goods"})
    public String user() {
        return "site/goods";
    }
    @GetMapping(value = {"/music"})
    public String music() {
        return "site/music";
    }
    @GetMapping(value = {"/news"})
    public String news() {
        return "site/news";
    }
    @GetMapping(value = {"/play"})
    public String play() {
        return "site/play";
    }
    @GetMapping(value = {"/user"})
    public String users() {
        return "site/user";
    }
    @GetMapping(value = {"/try"})
    public String travel() {
        return "site/index";
    }
    @GetMapping(value = {"/youke"})
    public String youke() {
        return "/youke";
    }
}
