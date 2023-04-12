package com.springbook.view.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;


@Controller 
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("admin");
		vo.setPassword("1111");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 인증 처리...");
		if (userService.getUser(vo) != null) {
			session.setAttribute("userId", userService.getUser(vo).getId());
			session.setAttribute("userName", userService.getUser(vo).getName());
			return "getBoardList.do";
		} else {
			return "login.jsp?error=1";
		}
	}
	
	@RequestMapping(value = "/joinGo.do")
	public String joinGo(@ModelAttribute("userJoin") UserVO vo) {
		System.out.println("회원가입 가보자구~!");
		
		userService.getJoin(vo);
		return "login.jsp";
	}
	
	@RequestMapping(value = "/deleteGo.do")
	public String deleteGo(UserVO vo, HttpSession session) {
		System.out.println("회원삭제 가보자구~!");
		vo.setId((String)session.getAttribute("userId"));
		System.out.println(vo.getId().getClass().getName());
		userService.getDelete(vo);
		return "login.jsp";
	}
	
	
	

	// get과 post방식을 둘 다 처리한다 => 동일한 url패턴을 사용할 수 없다.
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}

}
