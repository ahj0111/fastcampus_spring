package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller 
public class YoilTellerModelAndView {
	   	@RequestMapping("/getYoilMVC")
	   	public ModelAndView main(int year, int month, int day) throws IOException{
	   		
	   		ModelAndView mv = new ModelAndView();
	   		mv.setViewName("yoilError");
	   		// ��ȿ�� �˻�
	   		if(!isValid(year, month, day))
	   			return mv;
	   		
	   		// ���� ���
	   		char yoil = getYoil(year, month, day);
	   		
	   		// ����� ��� Model�� ����
	   		mv.addObject("year",year);
	   		mv.addObject("month",month);
	   		mv.addObject("day",day);
	   		mv.addObject("yoil",yoil);
	   		
	   		mv.setViewName("yoil");
	   		
	   		return mv;
	   	}

		private boolean isValid(int year, int month, int day) {
			// TODO Auto-generated method stub
			return true;
		}

		private char getYoil(int year, int month, int day) {//Refactor -> Extract Method
			Calendar cal = Calendar.getInstance();
	   		cal.set(year, month - 1, day);

	   		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	   		return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 
		}
}