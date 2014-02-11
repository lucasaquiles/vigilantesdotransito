package com.appspot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.actions.Actionable;
import com.appspot.actions.AddOccurrencyAction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author lucasaquiles
 *
 */
@SuppressWarnings("serial")
public class Hunter_Bad_DriverServlet extends HttpServlet {
	
	private static final Map<String, Actionable> SERVICES_BY_NAME = new HashMap<String, Actionable>();
	
	static {
		SERVICES_BY_NAME.put("add_occurrency", new AddOccurrencyAction());
		SERVICES_BY_NAME.put("list_occurrency", new AddOccurrencyAction());
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
			doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String serviceName = req.getParameter("service");
		
		Gson gson = new Gson();
		ReturnMessage returnMessage = null;
		RequestData fromJson = null;

		try {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader( req.getInputStream()));
			
			String readLine =  bufferedReader.readLine();
			
			Type token =  new TypeToken<RequestData>(){}.getType();
			fromJson = gson.fromJson(readLine, token);
			serviceName = fromJson.getServiceName();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (isValidServiceRequest(serviceName)) {

			Object result = null;
			Actionable action = getActionableByServiceName(serviceName);

			if (action != null) {

				try {
					
					result =  fromJson.getJsonData() != null ?action.execute(req, resp, fromJson.getJsonData()):action.execute(req, resp);

					returnMessage = new ReturnMessage("success", result);
				} catch (Exception e) {

					returnMessage = new ReturnMessage("error", e.getMessage());
				}
			}
		} else {

			returnMessage = new ReturnMessage("Error", "invalid action service");
		}

		if (returnMessage == null) {

			returnMessage = new ReturnMessage("empty", "zero_results");
		}

		String json = parseToJson(returnMessage);
		resp.getWriter().print(json);
	}
	
	public class ReturnMessage {

		private String type;
		private Object object;

		public ReturnMessage(String type, Object object) {

			this.type = type;
			this.object = object;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Object getObject() {
			return object;
		}

		public void setObject(Object object) {
			this.object = object;
		}
	}

	private String parseToJson(ReturnMessage returnMessage) {

		Gson gson = new Gson();
		return gson.toJson(returnMessage);
	}

	private Actionable getActionableByServiceName(String serviceName) {
		return SERVICES_BY_NAME.get(serviceName);
	}
	
	private boolean isValidServiceRequest(String serviceName) {
		return serviceName != null && !serviceName.trim().isEmpty();
	}
}
