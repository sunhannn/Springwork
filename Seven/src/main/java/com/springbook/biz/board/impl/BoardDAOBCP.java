package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
@Repository
public class BoardDAOBCP {

	// sql ���ɾ��
//		private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
//				+ "values ((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	private final String BOARD_INSERT = "insert into board(title, writer, content) " + "values( ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WHERE SEQ = ?";
	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// CRUD ����� �޼ҵ� ����
	// �۵��

	public void insertBoard(BoardVO vo) {
		System.out.println("======> JDBC�� insertBoard() ���ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());

	}

	// �ۼ���

	public void updateBoard(BoardVO vo) {
		System.out.println("======> JDBC�� updateBoard() ���ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());

	}

	// �ۻ���
	public void deleteBoard(BoardVO vo) {
		System.out.println("======> JDBC�� deleteBoard() ���ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());

	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("======> JDBC�� getBoard() ���ó��");
		Object[] args = { vo.getSeq() };
		return (BoardVO) jdbcTemplate.query(BOARD_GET, new BoardRowMapper(), args);

	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("======> JDBC�� getBoard() ���ó��");

		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}