package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
						// ���� ���� request, �������� ����� response
		// 1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. �۾�
		Calendar cal = Calendar.getInstance(); // 1:�Ͽ��� , 2:������ ...
		cal.set(yyyy,mm-1,dd);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfweek);
		
		// 3. ���
		response.setContentType("text/html");	
		// ����� ������ Ÿ���� ���־��Ѵ�.
		
		response.setCharacterEncoding("utf-8");	
		// �������� �츮�� ������ ������ �ؽ�Ʈ���� ���̳ʸ����� �𸣹Ƿ� �˷�����Ѵ�. ������ �ѱ��� ������.
		
		PrintWriter out = response.getWriter();	
		// response��ü���� ���������� ��� ��Ʈ���� ��´�. , ����ó��������Ѵ�.
		
		out.println(year+"�� "+month+"�� "+day+"���� ");
		out.println(yoil+"�����Դϴ�.");			
		// system.out �� �ֿܼ� ���, �׳� out�� �������� ���.
		
		
		
	}

}