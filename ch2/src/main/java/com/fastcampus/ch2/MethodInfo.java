package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//YoilTeller Ŭ���� ��ü ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		//��� �޼��� ������ �迭�� ����
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName();//�޼��� ��
			Parameter[] paramArr = m.getParameters();//�Ű����� ���
			Class returnType = m.getReturnType();//�޼��� ��ȯŸ��
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			//������ : , ���λ� : ( ���̻� : ) => (, , ,)
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();//�Ű����� ��
				Class  paramType = param.getType();//�Ű����� Ÿ��
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	}
}