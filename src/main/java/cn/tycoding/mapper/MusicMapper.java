package cn.tycoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import cn.tycoding.entity.Music;

@Mapper
public interface MusicMapper {
	    List<Music> findAll();

	    List<Music> findByPage(Music music);

	    List<Music> findById(Long id);

	    void create(Music music);

	    void update(Music music);

	    void delete(Long id);
	    List<Music>findByName(String name);
	    List<Music>findByBranc(String brand);
}
