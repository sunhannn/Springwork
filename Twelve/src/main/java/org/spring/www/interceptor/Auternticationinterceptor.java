package org.spring.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class Auternticationinterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 preHandler() 메소드 수행");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		String path = request.getServletPath(); // url에서 경로 (ontext제외한 나머지)만 가져오기
		System.out.println("path : " + path);

		if (obj == null) {

			response.sendRedirect("login.jsp");
			return false;

		} else if (path.contains("/updateBoard.do") || path.contains("/deleteBoard.do")) {
			if (!(request.getParameter("writer").equals(session.getAttribute("userName").toString()))) {
				System.out.println("수정삭제");
				response.sendRedirect("getBoard.do?error=1&seq=" + request.getParameter("seq"));
				return false;

			}

		}
		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
		// 다라서 true로 하면 컨트롤의 uri로 가게 됨.
		return true;

	}

	/*
	 * 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	 * 
	 * @Override 
	 * public boolean postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler) throws Exception {
	 * 
	 * System.out.println("인터셉터 postHandler() 메소드 수행");
	 * 
	 * }
	 */
}
