package com.appspot.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.dao.Dao;
import com.appspot.model.Occurrency;

public class ListOccurrencyAction implements Actionable {

	@Override
	public Object execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Dao dao = Dao.INSTANCE;
		List<Occurrency> occurrences = new ArrayList<Occurrency>();
		occurrences = dao.listOccurrencys();
		
		return occurrences;
	}

	@Override
	public Object execute(HttpServletRequest request,
			HttpServletResponse response, Object o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
