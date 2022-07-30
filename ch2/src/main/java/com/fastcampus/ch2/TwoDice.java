package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller				// 이미지 파일같이 변화가 없는것(js,css,html,..) --> 정적 리소스
public class TwoDice {	// 실행할 때 마다 결과가 변함(프로그램,스트리밍,..) --> 동적 리소스, 이 둘을 서버가 제공하는 리소스라한다.
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1;	// Math.random()*n : 0 ~ (n-1)의 랜덤한 (double형)수
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
