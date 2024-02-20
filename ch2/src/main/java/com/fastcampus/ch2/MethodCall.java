package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MethodCall {
	public static void main(String[] args) throws Exception{//Model 역할
		HashMap map = new HashMap();
		System.out.println("before:"+map);

		ModelController mc = new ModelController();
		String viewName = mc.main(map);//주소를 넘겨줌
		
		System.out.println("after :"+map);
		
		render(map, viewName);
	}
	
	static void render(HashMap map, String viewName) throws IOException {//View 역할
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();//id:${id}, pwd:${pwd}
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();//key : id, pwd
			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));//${id} -> asdf, ${pwd} -> 1111
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

class ModelController {//Controller 역할
	public String main(HashMap map) {
		//데이터 처리
		map.put("id", "asdf");
		map.put("pwd", "1111");
		//view 리턴
		return "txtView2";
	}
}