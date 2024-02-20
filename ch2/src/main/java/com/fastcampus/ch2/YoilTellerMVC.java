	package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller 
public class YoilTellerMVC {
	   	@RequestMapping("/getYoilMVC")
	   	public String main(int year, int month, int day, Model model) throws IOException{
	   		// 유효성 검사
	   		if(!isValid(year, month, day))
	   			return "yoilError";
	   		
	   		// 요일 계산
	   		char yoil = getYoil(year, month, day);
	   		
	   		// 계산한 결과 Model에 저장
	   		model.addAttribute("year",year);
	   		model.addAttribute("month",month);
	   		model.addAttribute("day",day);
	   		model.addAttribute("yoil",yoil);
	   		
	   		return "yoil";
	   	}

		private boolean isValid(int year, int month, int day) {
			// TODO Auto-generated method stub
			return true;
		}

		private char getYoil(int year, int month, int day) {//Refactor -> Extract Method
			Calendar cal = Calendar.getInstance();
	   		cal.set(year, month - 1, day);

	   		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	   		return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
		}
}