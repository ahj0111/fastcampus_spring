package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		//Hello 클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다
		Hello hello = (Hello)helloClass.newInstance();
		//Class객체가 가진 정보로 객체 생성
		Method main3 = helloClass.getDeclaredMethod("main3");//main이란 메서드 정보를 가져옴
		//main method를 밖에서 호출 할 수 있게함
		main3.setAccessible(true);//private이 main3()을 호출가능하게 함
		main3.invoke(hello);//hello.main3 호출
	}
}

