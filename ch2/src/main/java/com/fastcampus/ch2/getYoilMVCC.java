package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class getYoilMVCC {
	
	@RequestMapping("/getYoilMVCC") // 반환값을 안주면 Mapping된 jsp로 연결된다.
	public void main(int year,int month,int day,Model model) throws IOException {

		// 1 유효성 검사
//		if(isValid(year,month,day))
//			return "yoilError";
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
//		return "yoil";	// WEB-INF/views/yoil.jsp를 반환
	
		
		
	}

	private boolean isValid(int year, int month, int day) {
		return false;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance(); // 1:일요일 , 2:월요일 ...
		cal.set(year,month-1,day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfweek);
	}

}
