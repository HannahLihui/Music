package cn.tycoding.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tycoding.entity.Message;
import cn.tycoding.mapper.MessageMapper;
import cn.tycoding.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageMapper messageMapper;

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageMapper.findAll();
	}

	@Override
	public List<Message> findById(Long id) {
		// TODO Auto-generated method stub
		return messageMapper.findById(id);
	}

	@Override
	public void create(Message t) {
		// TODO Auto-generated method stub
		messageMapper.create(t);
	}

	@Override
	public void delete(Long... ids) {
		// TODO Auto-generated method stub
		 for (Long id : ids) {
			 messageMapper.delete(id);
	        }
	}

	@Override
	public void update(Message t) {
		// TODO Auto-generated method stub
		messageMapper.update(t);
	}


}
