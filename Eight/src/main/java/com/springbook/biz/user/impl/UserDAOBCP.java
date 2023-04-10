package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAOBCP")
public class UserDAOBCP {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String USER_GET = "select * from user where id=? and password=? ";

	public UserVO getUser(UserVO vo) {
		Object[] args = { vo.getId(), vo.getPassword() };
		try {

			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
