package com.site.ex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SP")
public class ScoreProcess extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuNo,stuName,kor,eng,math,avg = "";
		int total = 0;
		stuNo = request.getParameter("stuNo");
		stuName = request.getParameter("stuName");
		kor = request.getParameter("kor");
		eng = request.getParameter("eng");
		math = request.getParameter("math");
		total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
		avg = String.format("%.2f",(double)total/3);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n"
				+ "	<html>\r\n"
				+ "	<head>\r\n"
				+ "		<meta charset=\"UTF-8\">\r\n"
				+ "		<title>Insert title here</title>\r\n"
				+ "		<style type=\"text/css\">\r\n"
				+ "			table,td,th{\r\n"
				+ "				border:1px solid black; \r\n"
				+ "				border-collapse: collapse;\r\n"
				+ "				text-align: center;\r\n"
				+ "			}\r\n"
				+ "		</style>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "	<h3>학생성적 확인</h3>\r\n"
				+ "		<table>\r\n"
				+ "		<colgroup>\r\n"
				+ "			<col width = \"25%\">\r\n"
				+ "			<col width = \"25%\">\r\n"
				+ "			<col width = \"10%\">\r\n"
				+ "			<col width = \"10%\">\r\n"
				+ "			<col width = \"10%\">\r\n"
				+ "			<col width = \"10%\">\r\n"
				+ "			<col width = \"10%\">\r\n"
				+ "		</colgroup>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>학번</th>\r\n"
				+ "				<th>이름</th>\r\n"
				+ "				<th>국어</th>\r\n"
				+ "				<th>영어</th>\r\n"
				+ "				<th>수학</th>\r\n"
				+ "				<th>합계</th>\r\n"
				+ "				<th>평균</th>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>" +stuNo +  "</td>\r\n"
				+ "				<td>"+stuName +"</td>\r\n"
				+ "				<td>"+kor +"</td>\r\n"
				+ "				<td>"+eng +"</td>\r\n"
				+ "				<td>"+math +"</td>\r\n"
				+ "				<td>"+total +"</td>\r\n"
				+ "				<td>"+avg +"</td>\r\n"
				+ "			</tr>\r\n"
				+ "		</table>\r\n"
				+ "		<form action=\"./modify.jsp\" name = \"reusltForm\" method = \"post\">\r\n"
				+ "		<input type = \"hidden\" name = \"no\" value =" + stuNo +" >\r\n"
				+ "		<input type = \"hidden\" name = \"name\" value = >\r\n"
				+ "		<input type = \"hidden\" name = \"kor\" value = >\r\n"
				+ "		<input type = \"hidden\" name = \"eng\" value = >\r\n"
				+ "		<input type = \"hidden\" name = \"math\" value = >\r\n"
				+ "		<input type = \"submit\" value = \"수정\">\r\n"
				+ "		<input type = \"reset\" value = \"취소\">\r\n"
				+ "		</form>\r\n"
				+ "		\r\n"
				+ "	</body>\r\n"
				+ "</html>");
		pw.close();
	}

}
