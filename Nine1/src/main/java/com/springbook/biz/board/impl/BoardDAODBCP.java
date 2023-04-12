package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAODBCP {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// sql명령어들
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
//			+ "values( (select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	private final String BOARD_INSERT = "insert into board(title, writer, content) values(?, ?, ?)";
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title =?, writer=?, content=? where seq=? ";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_T = "select * from board where title like CONCAT('%',?,'%') order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like CONCAT('%',?,'%') order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능처리");
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// 글수정
	public int updateBoard(BoardVO vo) {
		// "update board set title =?, writer=?, content=? where seq=? ";
		System.out.println("===>Spring JDBC로 updateBoard() 기능처리");
		return jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq());
	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	// 글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoard() 기능처리");
		Object[] args = { vo.getSeq() };
		try {
			return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList() 기능처리: " + jdbcTemplate);

		Object[] args = { vo.getSearchKeyword() };
		if (vo.getSearchCondition() != null) {
			if (vo.getSearchCondition().equals("TITLE")) {
				System.out.println("TITLE: " + vo.getSearchKeyword());
				return jdbcTemplate.query(BOARD_LIST_T, new BoardRowMapper(), args);
			} else {
				System.out.println("CONTENT: " + vo.getSearchKeyword());
				return jdbcTemplate.query(BOARD_LIST_C, new BoardRowMapper(), args);
			}
		} else {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
	}

}