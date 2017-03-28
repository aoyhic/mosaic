package com.example.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

///login을 쓰려면 controller를 만들어야함 
@Controller
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String loginForm(){
		
		
		log.info("loginForm()");
		//로그인으로 들어오면 이 auth/loginForm으로 리다이렉트되도록
		return "auth/loginForm";
	}
}
