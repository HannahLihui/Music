package cn.tycoding.service;

import java.util.List;

import cn.tycoding.entity.Goods;
import cn.tycoding.entity.Music;
import cn.tycoding.entity.PageBean;

public interface MusicService extends BaseService<Music> {

    /**
     * 分页查询
     * @param goods 查询条件
     * @param pageCode 当前页
     * @param pageSize 每页的记录数
     * @return
     */
    List<Music> findByPage(Music music );

	List<Music> findByName(String musicSearch);

	List<Music> findByBrand(String brand);

	
}

