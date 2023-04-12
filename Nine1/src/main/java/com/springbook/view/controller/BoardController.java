package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller // import org.springframework.stereotype.Controller;
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
//      vo.setSeq(14);
		try {
			boardService.insertBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "getBoardList.do";
	}

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		return conditionMap;

	}

	// 글 수정 2 => 수정하고 원래 페이지로 나오게하기
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpSession session) {
		//외부에서의 커맨드 객체명 변경 ->board
		System.out.println("updateBoard.do vo : " + vo);

		if (vo.getWriter().equals(session.getAttribute("userName").toString())) {
			boardService.updateBoard(vo);
			return "getBoardList.do";

		} else {
			return "gteBoard.do?error=1";
		}

	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));

		return "WEB-INF/board/getBoard.jsp";
	}

	// 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardListPost(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리:");

		model.addAttribute("boardList", boardService.getBoardList(vo));
		System.out.println("getBoardList.do vo : " + vo);

		return "WEB-INF/board/getBoardList.jsp";
	}

}