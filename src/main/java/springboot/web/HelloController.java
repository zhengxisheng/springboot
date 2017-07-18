package springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.domain.User;

@RestController
public class HelloController {
	
	@Autowired
	private User user;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/hello")
	public String hello(){
		
		return user.getName();
	}
	@RequestMapping("/exception")
	public String exception() throws Exception{
	  throw new Exception("error");
	}
	@RequestMapping("/redisHandler")
	public String redisHandler(){
		stringRedisTemplate.opsForValue().set("k5", "Springboot redis");
		return stringRedisTemplate.opsForValue().get("k5");
	}
	
}
