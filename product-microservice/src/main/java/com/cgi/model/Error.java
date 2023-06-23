package com.cgi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	private int statusCode;
	private String errorMessage;
	private long errorReportingTime;
	
}
