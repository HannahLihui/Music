package cn.tycoding.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tycoding.entity.Goods;
import cn.tycoding.entity.Music;
import cn.tycoding.entity.News;
import cn.tycoding.entity.Result;
import cn.tycoding.service.GoodsService;
import cn.tycoding.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	 @Autowired
	    private NewsService newsService;
	 
	  @RequestMapping("/findByConPage")
	    public List<News> findByConPage(News goods) {
	        return newsService.findByPage(goods);
	    }
	 @RequestMapping("/create")
	    public Result create(@RequestBody News goods) {
	        try {
	            newsService.create(goods);
	            return new Result(true, "创建成功");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new Result(false, "发生未知错误");
	        }
	    }
	 @RequestMapping("findAll")
	    public List<News> fingAllMusic() {
	    	return newsService.findAll();
	    }

	    /**
	     * 更新数据成功
	     *
	     * @param goods
	     * @return
	     */
	    @RequestMapping("/update")
	    public Result update(@RequestBody News goods) {
	        try {
	            newsService.update(goods);
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
	            newsService.delete(ids);
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
	    public List<News> findById(@RequestParam(value = "id", required = false) Long id) {
	        return newsService.findById(id);
	    }
}
