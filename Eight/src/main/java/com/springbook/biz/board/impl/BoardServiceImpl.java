package com.springbook.biz.board.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource
	private BoardDAOBCP dao;

	@Override
	public void insertBoard(BoardVO vo) {
//		if (vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//			
//		}

		dao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {

		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {

		dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {

		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo, String keyword, String condition) {
		return dao.getBoardList(vo, keyword, condition);

	}

}
