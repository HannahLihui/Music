package cn.tycoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.tycoding.entity.Message;

@Mapper
public interface MessageMapper {
	  List<Message> findAll();

	    List<Message> findById(Long id);

	    void create(Message user);

	    void delete(Long id);

	    void update(Message user);
	    

}
