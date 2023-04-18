package com.springbook.view.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class Test {

	@Autowired
	private BoardService boardService;
	private UserService userService;

	@RequestMapping("/new.do")
//	public String newView(@RequestParam(value="up", required = false)String np) {
	public String newView(BoardVO vo) {
		vo.getTitle().toString();
//		int a= Integer.parseInt(np);

		return "NewFile.jsp";
	}

	@ResponseBody
	@RequestMapping("/test.do")
	public String testView() {
		System.out.println("test 처리");
		// LocalDateTime bow = LocalDateTime.now();
//		System.out.println(now);
//		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatedNow = sdf.format(day);

		return formatedNow;

	}

	@RequestMapping(value = "/reqAjax2.do")
	@ResponseBody
	public Object reqAjax2(BoardVO vo) {
		System.out.println("reqAjax2 처리");
//		vo.setTitle("제목입니다.")
		List<BoardVO> boardList = boardService.getBoardList(vo);

		Map<String, Object> retVal = new HashMap<String, Object>();

		retVal.put("code", "OK");
		retVal.put("boardList", boardList);
		return retVal;

	}

	@PostMapping(value = "/joongbok.do")
	@ResponseBody
	public Object joongbokCheck(UserVO vo) {
		System.out.println(vo.getId());
		Map<String, Object> retVal = new HashMap<String, Object>();

		boolean check = userService.joongbok(vo);
		System.out.println(check);
		String str = null;
		if (check) {
			str = "중복";

		} else {
			str = "통과";

		}

		retVal.put("code", "OK");
		retVal.put("joongBok", str);
		return retVal;

	}

}
