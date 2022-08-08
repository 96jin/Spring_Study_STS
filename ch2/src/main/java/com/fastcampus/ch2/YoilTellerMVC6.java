package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC6 {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("result"+result);
		FieldError error = result.getFieldError();
		
		System.out.println("code="+error.getCode());
		System.out.println("field="+error.getField());
		System.out.println("msg="+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC6")
//	public String main(@ModelAttribute("myDate") MyDate date, Model model){ // �Ʒ��� ����
	public String main(MyDate date, BindingResult result){
		System.out.println("result"+result);
		
		// 1 ��ȿ�� �˻�
		if(isValid(date))
			return "yoilError";
		
		// 2. ���� ���
//		char yoil = getYoil(date);
		
		// 3. ����� ����� model�� ����
//		model.addAttribute("myDate",date);
//		model.addAttribute("yoil",yoil);
		
		return "yoil";	// WEB-INF/views/yoil.jsp�� ��ȯ
	
		
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
		
			return false;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance(); // 1:�Ͽ��� , 2:������ ...
		cal.set(year,month-1,day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfweek);
	}

}
