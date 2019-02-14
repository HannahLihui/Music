package cn.tycoding.controller.admin;

import cn.tycoding.entity.User;
import cn.tycoding.entity.Result;
import cn.tycoding.entity.User;
import cn.tycoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @auther TyCoding
 * @date 2018/9/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 分页查询
     *
     * @param goods    查询条件
     * @param pageCode 当前页
     * @param pageSize 每页显示的记录数
     * @return
     */
    @RequestMapping("/orderSubmit")
	public void orderSubmit(@RequestBody Map<String, Object> ruleForm ) {
		  String itemid= (String) ruleForm.get("itemid");
		  String address= (String) ruleForm.get("address");
		  System.out.println(itemid);
		
	}
    @RequestMapping("/findByConPage")
    public List<User> findByConPage(User User) {
        return userService.findByPage(User);
    }
   
    @RequestMapping("findAll")
    public List<User> fingAllUser() {
    	return userService.findAll();
    }
 
  
    @RequestMapping("/create")
    public Result create(@RequestBody User goods) {
        try {
            userService.create(goods);
            return new Result(true, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 更新数据成功
     *
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody User goods) {
        try {
            userService.update(goods);
            return new Result(true, "更新数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long... ids) {
        try {
            userService.delete(ids);
            return new Result(true, "更新数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public List<User> findById( @RequestParam(value = "id", required = false) String id) {
    	System.out.println(id);
    	System.out.println(userService.findById(Long.parseLong(id)).size());
        return userService.findById(Long.parseLong(id));
    }
   

}
