package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//@Service("boardService")
@Component("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAODBCP boardDAO;

	// 글 등록
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
//		boardDAO.insertBoard(vo);
	};

	// 글 수정
//	public void updateBoard(BoardVO vo) {
//		boardDAO.updateBoard(vo);
//	};
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	};

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	};

	// 글 상세보기 조회
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	};

	// 글 전체목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	//조회수 업데이트
	
	@Override
	public void updateCnt(BoardVO vo) {
		System.out.println("업데이트 실행");
		boardDAO.updateCnt(vo);
	}


}
