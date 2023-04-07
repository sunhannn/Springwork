package com.springbook.biz.board.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource
	private BoardDAO dao;

	@Override
	public void insertBoard(BoardVO vo) {

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
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);

	}

}
