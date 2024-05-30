package com.web.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EnrollByKakaoServlet
 */
@WebServlet("/user/enrollbykakao.do")
public class EnrollByKakaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollByKakaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while((line=reader.readLine())!=null) {
			sb.append(line);
		}		
		Gson gson = new Gson();
		//System.out.println(sb);
		//json형식으로 문자열로 담긴 객체 id, emaill, num을 파싱
		//Pattern pattern = Pattern.compile("\"([^\"]+)\":\"([^\"]+)\"");
	    //Matcher matcher = pattern.matcher(sb);
	    //System.out.println();
	    //while (matcher.find()) {
	    //    String key = matcher.group(1);
	    //    String value = matcher.group(2).replaceAll("\\\\", ""); // 역슬래시 제거
	    //    System.out.println(key + ": " + value);
	    //}
		gson.toJson(sb, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
