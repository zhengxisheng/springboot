package springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.addObject("exception",e);
		modelAndView.addObject("url",req.getRequestURI());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
