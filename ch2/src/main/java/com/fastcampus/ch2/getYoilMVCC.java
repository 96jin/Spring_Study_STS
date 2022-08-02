package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class getYoilMVCC {
	
	@RequestMapping("/getYoilMVCC") // ��ȯ���� ���ָ� Mapping�� jsp�� ����ȴ�.
	public void main(int year,int month,int day,Model model) throws IOException {

		// 1 ��ȿ�� �˻�
//		if(isValid(year,month,day))
//			return "yoilError";
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. ����� ����� model�� ����
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
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
