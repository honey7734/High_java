package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		//form에서 가져온 데이터 userid, pass, chkid값 받아오기
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String chkid = request.getParameter("chkid");
		Cookie idCookie = new Cookie("userId", userid);
		
		System.out.println("체크여부 : " + chkid);
		// 체크박스의 체크여부에 따라 쿠키 저장하기
		if(chkid != null) {	// 체크 박스가 체크 되었을 때
			response.addCookie(idCookie); // 쿠키 저장
		}else {	// 체크 박스가 체크가 해제되었을 떄
			idCookie.setMaxAge(0);
			response.addCookie(idCookie);
		}
		
		//로그인 성공여부 확인
		
		// userid와 pass의 null 체크 ==> 반드시 해주는 것이 좋다.
		if(userid != null && pass != null) {
			// 로그인 성공
			if(userid.equals("test") && pass.equals("1234")) {
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieMain.jsp");
			}else {	// 로그인 실패
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieLogin.jsp");
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/basic/02/cookieLogin.jsp");
		}
	}
	
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
