package cn.tycoding.controller.admin;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tycoding.entity.Goods;
import cn.tycoding.entity.Music;
import cn.tycoding.entity.PageBean;
import cn.tycoding.entity.Result;
import cn.tycoding.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
	 @Autowired
	    private MusicService musicService;

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
	    public List<Music> findByConPage(Music music) {
	        return musicService.findByPage(music);
	    }
	   
	    @RequestMapping("findAll")
	    public List<Music> fingAllMusic() {
	    	return musicService.findAll();
	    }
	 
	  
	    @RequestMapping("/create")
	    public Result create(@RequestBody Music goods) {
	        try {
	            musicService.create(goods);
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
	    public Result update(@RequestBody Music goods) {
	        try {
	            musicService.update(goods);
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
	            musicService.delete(ids);
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
	    public List<Music> findById( @RequestParam(value = "id", required = false) String id) {
	    	System.out.println(id);
	    	System.out.println(musicService.findById(Long.parseLong(id)).size());
	        return musicService.findById(Long.parseLong(id));
	    }
	    @RequestMapping("/findByName")
	    public List<Music> findByName( @RequestParam(value = "musicSearch", required = false) String musicSearch) {
	    	System.out.println(musicSearch);
	    	
	        return musicService.findByName(musicSearch);
	    }
	    @RequestMapping("/findByBrand")
	    public List<Music> findByBrand( @RequestParam(value = "brand", required = false) String brand) {
	    	System.out.println(brand);
	    	
	        return musicService.findByBrand(brand);
	    }


}
