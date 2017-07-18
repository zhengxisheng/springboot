package springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/* 统一返回错误页面
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.addObject("exception",e);
		modelAndView.addObject("url",req.getRequestURI());
		modelAndView.setViewName("error");
		return modelAndView;
	}
	**/
	
	//统一返回json错误信息
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e){
		ErrorInfo<String> r = new ErrorInfo<String>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Return jsonException");
		r.setUrl(req.getRequestURI());
		return r;
	}
}

