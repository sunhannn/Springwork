package com.springbook.biz;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/resource/js/common.js")
	public void home(HttpServletRequest req) {
		System.out.println("path : " + req.getServletPath());

	}

	@RequestMapping("/resources/css/common.css")
	public void home2(HttpServletRequest req) {

		System.out.println("path : " + req.getServletPath());
	}

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateformat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "intercept/home";

	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "intercept/login";

	}

	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String loginAction(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		String userId = req.getParameter("userId");

		session.setAttribute("userId", userId);
		return "redirect:/main.do";

	}

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main() {
		return "intercept/main";

	}

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		return "intercept/join";

	}

//	Pathvarialble 예제
	@RequestMapping("/pathervar/page/{var}")
	public String page(@PathVariable("var") String v) {
		String returnUrl = "";

		if (v.equals("one")) {
			returnUrl = "pathvar/page1";

		} else if (v.equals("two")) {

			returnUrl = "pathvar/page2";
		}

		return returnUrl;
	}

	// GET 방식 컨트롤러
	// @param key1
	// @param key2

	@RequestMapping("/pathvar/byGet")
	public String resultByGet(@RequestParam(value = "key1") String k1, @RequestParam(value = "key2") String k2,
			Model model) {

//		System.out.println("key1"+key1);
//		System.out.println("key2"+key2);

		model.addAttribute("key1" + k1);
		model.addAttribute("key2" + k2);
		return "pathvar/path";

	}

	// Pathvariable 방식 컨트롤러
	// @Param key1
	// @Param key2

	@RequestMapping("/pathvar/byPath/{key1}/{key2}")
	public String resultByPath(@PathVariable String key1, @PathVariable String key2) {

		System.out.println("Path key1 ::: " + key1);
		System.out.println("Path key2 ::: " + key2);

		return "pathvar/path";
	}

}
