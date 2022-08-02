package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class getYoilModelAndView {
	
	@RequestMapping("/getYoilMV") // ��ȯ���� ���ָ� Mapping�� jsp�� ����ȴ�.
	public ModelAndView main(int year,int month,int day) throws IOException {
		ModelAndView mv = new ModelAndView();
		// 1 ��ȿ�� �˻�
//		if(isValid(year,month,day))
//			return "yoilError";
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. ����� ����� model�� ����
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		// 4. ����� ������ view�� ����
		mv.setViewName("yoil");
		return mv;
//		return "yoil";	// WEB-INF/views/yoil.jsp�� ��ȯ
	
		
		
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
