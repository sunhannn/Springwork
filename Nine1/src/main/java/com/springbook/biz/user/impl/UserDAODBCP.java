package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String USER_GET = "select * from user where id=? and password=? ";
	private final String USER_JOIN = "insert into user values (? ,? ,? ,?)";
	private final String USER_DELETE = "delete from user where id = ?";

	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 getUser() 기능처리");
		Object[] args = { vo.getId(), vo.getPassword() }; // admin, 1234

		try {
			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), args);
//			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), vo.getId() , vo.getPassword());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void getJoin(UserVO vo) {
		System.out.println("===> Spring JDBC로 getJoin() 기능처리");
		System.out.println(vo.getId());
		System.out.println(vo.getPassword());
		System.out.println(vo.getName());
		System.out.println(vo.getRole());
		jdbcTemplate.update(USER_JOIN, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());

	}

	public void getDelete(UserVO vo) {
		System.out.println("===> Spring JDBC로 getDlete() 기능처리");

		jdbcTemplate.update(USER_DELETE, vo.getId());

	}

}
