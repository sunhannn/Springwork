package com.springbook.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestImpl implements Test{
	@Autowired
	private TestDAO td;
 
	@Override
	//����Ʈ��
	public int getNum() {
		return td.getNum();
	}

	@Override
	public void setNum(int no) {
		td.setNum(no);
	}

	@Override
	public void setNum(String str, int no) {
		td.setNum(str, no);
	}

}