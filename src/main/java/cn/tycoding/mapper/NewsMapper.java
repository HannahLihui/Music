package cn.tycoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import cn.tycoding.entity.Music;
import cn.tycoding.entity.News;

@Mapper
public interface NewsMapper {
	   List<News> findAll();

	    List<News> findByPage(News n);

	    List<News> findById(Long id);

	    void create(News n);

	    void update(News n);

	    void delete(Long id);
}
