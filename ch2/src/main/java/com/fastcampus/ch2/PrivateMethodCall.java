package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		//Hello Ŭ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�
		Hello hello = (Hello)helloClass.newInstance();
		//Class��ü�� ���� ������ ��ü ����
		Method main3 = helloClass.getDeclaredMethod("main3");//main�̶� �޼��� ������ ������
		//main method�� �ۿ��� ȣ�� �� �� �ְ���
		main3.setAccessible(true);//private�� main3()�� ȣ�Ⱑ���ϰ� ��
		main3.invoke(hello);//hello.main3 ȣ��
	}
}

