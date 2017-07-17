package springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.domain.User;

@RestController
public class HelloController {
	
	@Autowired
	private User user;
	
	@RequestMapping("/hello")
	public String hello(){
		
		return user.getName();
	}
	
	@RequestMapping("/exception")
	public String exception() throws Exception{
	  throw new Exception("error");
	}
	
	
	@RequestMapping("/runtimeException")
	public String runtimeException() throws RuntimeException{
		throw new RuntimeException("运行时异常..");
	}

}
