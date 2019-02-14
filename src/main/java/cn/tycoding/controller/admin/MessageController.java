package cn.tycoding.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tycoding.entity.Message;
import cn.tycoding.entity.Music;
import cn.tycoding.entity.Result;
import cn.tycoding.service.MessageService;


@RestController
@RequestMapping("/message")
public class MessageController {
	 @Autowired
	    private MessageService messageService;
	 @RequestMapping("findAll")
	    public List< Message> fingAllUser() {
	    	return messageService.findAll();
	    }
	  @RequestMapping("/findById")
	    public List<Message> findById( @RequestParam(value = "id", required = false) String id) {
	    	System.out.println(id);
	    	System.out.println(messageService.findById(Long.parseLong(id)).size());
	        return messageService.findById(Long.parseLong(id));
	    }
	  @RequestMapping("/create")
	    public Result update(@RequestParam(value = "id", required = false) String id,
	    		@RequestParam(value = "content", required = false) String content,
	    		@RequestParam(value = "name", required = false) String name) {
		  Message m=new Message(Long.parseLong(id),content,name);
	        try {
	        	messageService.create(m);
	            return new Result(true, "更新数据成功");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new Result(false, "发生未知错误");
	        }
	    }

	 
}
