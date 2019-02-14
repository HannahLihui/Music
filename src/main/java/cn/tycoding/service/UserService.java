package cn.tycoding.service;

import java.util.List;

import cn.tycoding.entity.Music;
import cn.tycoding.entity.User;


public interface UserService extends BaseService<User> {

    User findByName(String name);

	List<Music> findByPage(Music music);

	List<User> findByPage(User user);
}
