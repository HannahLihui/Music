package cn.tycoding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tycoding.entity.Music;
import cn.tycoding.entity.News;
import cn.tycoding.mapper.MusicMapper;
import cn.tycoding.mapper.NewsMapper;
import cn.tycoding.service.MusicService;
import cn.tycoding.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
    private NewsMapper newsMapper;

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return newsMapper.findAll();
	}

	@Override
	public List<News> findById(Long id) {
		// TODO Auto-generated method stub
		return newsMapper.findById(id);
	}

	@Override
	public void create(News t) {
		// TODO Auto-generated method stub
		newsMapper.create(t);
	}

	@Override
	public void delete(Long... ids) {
		// TODO Auto-generated method stub
		 for (Long id : ids) {
	            newsMapper.delete(id);
	        }
	}

	@Override
	public void update(News t) {
		// TODO Auto-generated method stub
		newsMapper.update(t);
	}
}
