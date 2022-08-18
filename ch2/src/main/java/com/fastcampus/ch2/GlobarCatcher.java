package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice("com.fastcampus.ch2")	// �ش��ϴ� ��Ű������ �߻��� ���ܸ� ó��
//@ControllerAdvice	// ��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ���⿡�� ó��. (���������� ó�� �� ����)
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
