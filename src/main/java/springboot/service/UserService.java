package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.dao.UserMapper;
import springboot.domain.User;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public User findById(String id){
		return userMapper.findById(id);
	}
	
	public int addUser(String name,String age){
		return userMapper.addUser(name,age);
	}
}
