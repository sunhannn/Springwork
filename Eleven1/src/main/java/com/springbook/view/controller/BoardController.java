package com.springbook.view.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.net.URLEncoder;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

// 상대경로를 절대경로로 변경해주는 경우
// public String insertBoard(MultipartHttpServletRequest request, BoardVO vo)
//throws IllegalStateException, IOException

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

	// 상대경로를 절대경로로 변경해주는 경우
	// public String insertBoard(MultipartHttpServletRequest request, BoardVO vo)
	// throws IllegalStateException, IOException

	@PostMapping(value = "/insertBoard.do")
	public String insertBoards(BoardVO vo) throws IllegalArgumentException, IOException {
		MultipartFile uploadFile = vo.getUploadFile();

		// 상대 경로를 절대경로로 변경해주는 경우 realPath 추가
		// String realPath = request.getSession().getServletContext.getRealPath("/img/")
		String realPath = "c:/Springwork/ten/src/main/webapp/boardUpload/";
		String fileName = uploadFile.getOriginalFilename();

		if (!uploadFile.isEmpty()) {
			vo.setFilename(fileName);
			uploadFile.transferTo(new File(realPath + fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";

	}

	// 글 수정 2 => 수정하고 원래 페이지로 나오게하기
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpSession session) {
		// 외부에서의 커맨드 객체명 변경 ->board
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
	public String deleteBoard(BoardVO vo) throws IllegalStateException, IOException {

		vo = boardService.getBoard(vo);

		String realPath = "c:/Springwork/ten/src/main/webapp/boardUpload/";
		String fileName = vo.getFilename();
		boardService.deleteBoard(vo);
		File file = new File(realPath + fileName);
		if (file.exists())
			file.delete();

		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		
		boardService.updateCnt(vo);
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

	// 파일 다운로드
	@GetMapping("/download.do")
	public void download(HttpServletResponse response, HttpServletRequest request) throws Exception {
		try {
			String path = "C:\\Springwork\\Ten\\src\\main\\webapp\\boardUpload"; // 경로에 접근할 때 역슬래시('\') 사용
			String fileName = request.getParameter("fname");
			File dFile = new File(path, fileName);
			System.out.println();
			int fSize = (int) dFile.length();
			// 파일이 존재
			if (fSize > 0) {

				// 파일명을 URLEncoder 하여 attachment, Content-Disposition Header로 설정
				String encodedFilename = "attachment; filename*=" + "UTF-8" + "''"
						+ URLEncoder.encode(fileName, "UTF-8");

				// ContentType 설정
				response.setContentType("application/octet-stream; charset=utf-8");

				// Header 설정
				response.setHeader("Content-Disposition", encodedFilename);

				// ContentLength 설정
				response.setContentLength(fSize);

				BufferedInputStream in = null;
				BufferedOutputStream out = null;

				in = new BufferedInputStream(new FileInputStream(dFile));
				out = new BufferedOutputStream(response.getOutputStream());

				try {
					byte[] buffer = new byte[4096];
					int bytesRead = 0;

					/*
					 * 모두 현재 파일 포인터 위치를 기준으로 함 (파일 포인터 앞의 내용은 없는 것처럼 작동) int read() : 1byte씩 내용을 읽어
					 * 정수로 반환 int read(byte[] b) : 파일 내용을 한번에 모두 읽어서 배열에 저장 int read(byte[] b. int
					 * off, int len) : 'len'길이만큼만 읽어서 배열의 'off'번째 위치부터 저장
					 */
					while ((bytesRead = in.read(buffer)) != -1) {
						out.write(buffer, 0, bytesRead);
					}

					// 버퍼에 남은 내용이 있다면, 모두 파일에 출력
					out.flush();
				} finally {
					/*
					 * 현재 열려 in,out 스트림을 닫음 메모리 누수를 방지하고 다른 곳에서 리소스 사용이 가능하게 만듬
					 */
					in.close();
					out.close();
				}
			} else {
				throw new FileNotFoundException("파일이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}