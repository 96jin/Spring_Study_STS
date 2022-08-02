package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class getYoilModelAndView {
	
	@RequestMapping("/getYoilMV") // 반환값을 안주면 Mapping된 jsp로 연결된다.
	public ModelAndView main(int year,int month,int day) throws IOException {
		ModelAndView mv = new ModelAndView();
		// 1 유효성 검사
//		if(isValid(year,month,day))
//			return "yoilError";
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 model에 저장
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		// 4. 결과를 보여줄 view를 지정
		mv.setViewName("yoil");
		return mv;
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
