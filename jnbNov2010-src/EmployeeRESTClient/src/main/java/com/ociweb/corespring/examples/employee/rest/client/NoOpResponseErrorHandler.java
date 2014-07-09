package com.ociweb.corespring.examples.employee.rest.client;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class NoOpResponseErrorHandler implements ResponseErrorHandler {

	public void handleError(ClientHttpResponse response) throws IOException {
		//do nothing
	}
	
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return false;
	}

}
