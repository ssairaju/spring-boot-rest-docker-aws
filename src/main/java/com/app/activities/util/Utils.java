package com.app.activities.util;

import javax.servlet.http.HttpServletResponse;

import com.app.activities.constants.Constants;
import com.app.activities.model.json.MessageEnvelope;
import com.app.activities.model.json.MessageHeaders;
import com.app.activities.model.json.MessageOnlyBody;

public class Utils {
	public static MessageEnvelope<MessageOnlyBody> errorMessageEnvelope(HttpServletResponse servletResponse, Exception e) {
		MessageEnvelope<MessageOnlyBody> errorEnvelope = new MessageEnvelope<MessageOnlyBody>();
		MessageHeaders headers = messageHeader(Constants.ERROR, Constants.EMPTY_STRING);
		errorEnvelope.setHeader(headers);
		MessageOnlyBody errorBody = new MessageOnlyBody();
		errorBody.setMessage( e.getMessage() );
		errorEnvelope.setBody(errorBody);
		servletResponse.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR  );
		return errorEnvelope;
	}

	public static MessageHeaders messageHeader(String status, String message) {
		MessageHeaders headers = new MessageHeaders();
		headers.setStatus( status );
		headers.setMessage(message);
		return headers;
	}
}