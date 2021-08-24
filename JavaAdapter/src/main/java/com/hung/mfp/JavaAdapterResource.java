/*
 *    Licensed Materials - Property of IBM
 *    5725-I43 (C) Copyright IBM Corp. 2015, 2016. All Rights Reserved.
 *    US Government Users Restricted Rights - Use, duplication or
 *    disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.hung.mfp;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpRequest;

import com.hung.mfp.request.ConsumersRequest;
import com.ibm.json.java.JSONObject;
import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.OAuthSecurity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Sample Adapter Resource")
@Path("/api")
public class JavaAdapterResource {
	/*
	 * For more info on JAX-RS see
	 * https://jax-rs-spec.java.net/nonav/2.0-rev-a/apidocs/index.html
	 */

	// Define logger (Standard java.util.Logger)
	static Logger logger = Logger.getLogger(JavaAdapterResource.class.getName());

	// Inject the MFP configuration API:
	@Context
	ConfigurationAPI configApi;
	
	@Context
	HttpServletRequest httpRequest;
	
	
	@GET
	@Path("/getRequestHeader")
	public String getRequestHeader() {
		String response = "";
		Enumeration<String> e = httpRequest.getHeaderNames();
		while (e.hasMoreElements()) {
			String headerName = e.nextElement();
			String headerValue = httpRequest.getHeader(headerName);
			response += headerName + "/n/n"+ headerValue;
		}
		return response;
	}
//	@GET
//	@Path("/getRequestHeader")
//	@Produces(MediaType.APPLICATION_JSON)
//	@OAuthSecurity(enabled = false)
//	public JSONObject getRequestHeader() {
//		String headerName = "";
//		String headerValue = "";
//		Enumeration<String> e = httpRequest.getHeaderNames();
//		while (e.hasMoreElements()) {
//			headerName = e.nextElement();
//			headerValue = httpRequest.getHeader(headerName);
//		}
//		JSONObject data = new JSONObject();
//		data.put("headerName", headerName);
//		data.put("headerValue", headerValue);
//		return data;
//	}
	
	

	@ApiOperation(value = "Custom Scope Protection", notes = "Example of a resource that is protected by a custom scope. To access this resource a valid token for the scope 'myCustomScope' must be acquired.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "A constant string is returned") })
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN) // trả về Text
	@OAuthSecurity(enabled = false)
	public String helloHung() {
		return "Hello my name Hùng!";
	}
	@GET
	@Path("/test1")
	@Produces(MediaType.APPLICATION_JSON) // trả về Text
	@OAuthSecurity(enabled = false)
	public JSONObject helloHung1() {
		JSONObject data = new JSONObject();
		data.put("data", "Hello my name Hùng!");
		return data;
	}
	@GET
	@Path("/test_json")
	@Produces(MediaType.APPLICATION_JSON)// trả về Json
	@OAuthSecurity(enabled = false)
	public JSONObject jsonExample() {
		JSONObject data = new JSONObject();
		data.put("key", "hung");
		return data;
	}
	
	@POST
	@Path("/test_json_consumers")
	@Produces(MediaType.APPLICATION_JSON)// trả về Json
	@Consumes(MediaType.APPLICATION_JSON)// Đầu vào kiểu Json
	@OAuthSecurity(enabled = false)
	public JSONObject jsonComsumerExample(ConsumersRequest request) {
		JSONObject data = new JSONObject();
		data.put("key", request.getName());
		return data;
	}
	
	@POST
	@Path("/path_param/{name}")
	@Produces(MediaType.APPLICATION_JSON)// trả về Json
	@OAuthSecurity(enabled = false)
	public JSONObject jsonComsumerExample(@PathParam(value="name") String name) {
		JSONObject data = new JSONObject();
		data.put("name", name);
		return data;
	}

}
