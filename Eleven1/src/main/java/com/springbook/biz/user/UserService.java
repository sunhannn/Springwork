package com.springbook.biz.user;

public interface UserService {

	UserVO getUser(UserVO vo);
	void getJoin(UserVO vo);
	void getDelete(UserVO vo);
	void getUpdate(UserVO vo, String userId);
	boolean joongbok(UserVO vo);
}