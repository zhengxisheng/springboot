package springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import springboot.dao.DubboService;
import springboot.domain.User;
import springboot.service.UserService;


@RestController
public class HelloController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private UserService userService;
	@Autowired
	private DubboService dubboService;

	
	@RequestMapping("/exception")
	public String exception() throws Exception{
	  throw new Exception("error");
	}
//	@RequestMapping("/hello")
//	public String hello(){
//		return dubboService.sayHello();
//	}
	@RequestMapping("/redisHandler")
	public String redisHandler(){
		stringRedisTemplate.opsForValue().set("k5", "Springboot redis");
		return stringRedisTemplate.opsForValue().get("k5");
	}
	@RequestMapping("/adduser")
	public int addUser(@RequestParam("name")String name,@RequestParam("age")String age){
		return userService.addUser(name, age);
	}
	@RequestMapping("/findUser")
	public User findUser(@RequestParam("id") String id){
		return userService.findById(id);
	}
	@RequestMapping("/updataById")
	public String updataById(@RequestParam("id") String id,@RequestParam("name") String name){
		try {
			userService.updataById(id, name);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("id") String id){
		try {
			userService.deleteById(id);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
}
