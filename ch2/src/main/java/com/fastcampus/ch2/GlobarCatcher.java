package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice("com.fastcampus.ch2")	// 해당하는 패키지에서 발생한 예외만 처리
//@ControllerAdvice	// 모든 컨트롤러에서 발생하는 예외를 여기에서 처리. (공통적으로 처리 할 예외)
public class GlobarCatcher {
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}
}
