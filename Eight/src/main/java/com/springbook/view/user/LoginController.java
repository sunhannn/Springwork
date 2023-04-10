package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAOBCP;

public class LoginController implements Controller {
	@Autowired
	UserDAOBCP userDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserVO user = userDAO.getUser(vo);

		ModelAndView mav = new ModelAndView();
		if (user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			mav.setViewName("redirect:getBoardList.do");
		} else {
//			return "login.jsp?error=1";
			session.setAttribute("error", 1);
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
