package cn.tycoding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.tycoding.entity.Goods;
import cn.tycoding.entity.Music;
import cn.tycoding.entity.PageBean;
import cn.tycoding.mapper.GoodsMapper;
import cn.tycoding.mapper.MusicMapper;
import cn.tycoding.service.MusicService;
@Service
public class MusicServiceImpl implements MusicService{
	@Autowired
    private MusicMapper musicMapper;


	@Override
	public List<Music> findAll() {
		// TODO Auto-generated method stub
		return musicMapper.findAll();
	}

	@Override
	public List<Music> findById(Long id) {
		// TODO Auto-generated method stub
		return musicMapper.findById(id);
	}

	@Override
	public void create(Music t) {
		// TODO Auto-generated method stub
		musicMapper.create(t);
	}

	@Override
	public void delete(Long... ids) {
		// TODO Auto-generated method stub
		 for (Long id : ids) {
	            musicMapper.delete(id);
	        }
	}

	@Override
	public void update(Music t) {
		// TODO Auto-generated method stub
		musicMapper.update(t);
		
	}

	@Override
	public List<Music> findByPage(Music music) {
		// TODO Auto-generated method stub
		 //使用Mybatis分页插件
      
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Music> page = musicMapper.findByPage(music);

        return page;
	}

	@Override
	public List<Music> findByName(String musicSearch) {
		// TODO Auto-generated method stub
		return musicMapper.findByName(musicSearch);
	}

	@Override
	public List<Music> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return musicMapper.findByBranc(brand);
	}

}
