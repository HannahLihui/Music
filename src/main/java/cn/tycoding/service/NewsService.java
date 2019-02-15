package cn.tycoding.service;

import java.util.List;

import cn.tycoding.entity.Music;
import cn.tycoding.entity.News;

public interface NewsService  extends BaseService<News>{

	List<News> findByPage(News goods);

}
