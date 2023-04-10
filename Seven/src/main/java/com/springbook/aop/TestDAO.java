package com.springbook.aop;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("testDAO")
public class TestDAO implements Test {

	public int getNum(){
		System.out.println("getNum()메소드 호출");
		return 1;
	}
	
	public void setNum(int no) {
		System.out.println("setNum()메소드 호출: "+no);
	}
	
	public void setNum(String str, int no) {
		System.out.println("setNum()메소드 호출: "+str+", "+no);
	}

}
