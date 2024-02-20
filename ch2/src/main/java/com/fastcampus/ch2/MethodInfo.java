package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//YoilTeller 클래스 객체 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		//모든 메서드 정보를 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName();//메서드 명
			Parameter[] paramArr = m.getParameters();//매개변수 목록
			Class returnType = m.getReturnType();//메서드 반환타입
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			//구분자 : , 접두사 : ( 접미사 : ) => (, , ,)
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();//매개변수 명
				Class  paramType = param.getType();//매개변수 타입
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	}
}