package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("insert 기능처리");
		mybatis.insert("BoardDAO.insertBoard", vo);

	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("update 실행");
		mybatis.update("BoardDAO.updateBoard", vo);

	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("delete 기능실행");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard 기능실행");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
		//한줄 데이터 일때 selectOne
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList() 기능처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);

	}

}
