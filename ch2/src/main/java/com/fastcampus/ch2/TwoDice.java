package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller				// �̹��� ���ϰ��� ��ȭ�� ���°�(js,css,html,..) --> ���� ���ҽ�
public class TwoDice {	// ������ �� ���� ����� ����(���α׷�,��Ʈ����,..) --> ���� ���ҽ�, �� ���� ������ �����ϴ� ���ҽ����Ѵ�.
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1;	// Math.random()*n : 0 ~ (n-1)�� ������ (double��)��
		int idx2 = (int)(Math.random()*6)+1;
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/diceimg/dice"+idx1+".jpg'>");
		out.println("<img src='resources/diceimg/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}
}
