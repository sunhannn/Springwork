package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServeImpl implements UserService {
	@Autowired
	private UserDAODBCP userDAO;

	public void setUserDAO(UserDAODBCP userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void getJoin(UserVO vo) {
		userDAO.getJoin(vo);

	}
	
	@Override
	public void getDelete(UserVO vo ) {
		userDAO.getDelete(vo);
		
	}
	
	@Override
	public void getUpdate(UserVO vo, String userId) {
		userDAO.getUpdate(vo, userId);
		
	}
	
	
	@Override
	public boolean joongbok(UserVO vo) {
		UserVO vo1 = new UserVO();
		System.out.println("중복체크~");
		vo1 = userDAO.joongbok(vo);
		if (vo1 == null) {
			return true;
		}
		
		
		return false;
	}
}
