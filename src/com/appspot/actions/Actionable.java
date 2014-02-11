package com.appspot.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author lucasaquiles
 *
 */
public interface Actionable{
	
	public Object execute( HttpServletRequest request , HttpServletResponse response );
	public Object execute( HttpServletRequest request , HttpServletResponse response, Object o) throws Exception;
}
