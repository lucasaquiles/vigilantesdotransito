package com.appspot.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.dao.Dao;

public class AddOccurrencyAction  implements Actionable{

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		
		String plate = checkNull(request.getParameter("plate"));
		String type = checkNull(request.getParameter("type"));
		String description = checkNull(request.getParameter("description"));
		
		Dao.INSTANCE.add(plate, type, description);
		
		return null;
	}

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
			
		return null;
	}

	private String checkNull(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
}
