/*
 *    Licensed Materials - Property of IBM
 *    5725-I43 (C) Copyright IBM Corp. 2015, 2016. All Rights Reserved.
 *    US Government Users Restricted Rights - Use, duplication or
 *    disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.hung.springadapter.rest;

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

import org.springframework.beans.factory.annotation.Autowired;

import com.hung.springadapter.request.ConsumersRequest;
import com.hung.springadapter.request.LoginRequest;
import com.hung.springadapter.service.CustomerService;
import com.ibm.json.java.JSONObject;
import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.OAuthSecurity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Sample Adapter Resource")
@Path("/mfpadapter")
public class SpringAdapterResource {
	/*
	 * For more info on JAX-RS see
	 * https://jax-rs-spec.java.net/nonav/2.0-rev-a/apidocs/index.html
	 */

	// Define logger (Standard java.util.Logger)
	static Logger logger = Logger.getLogger(SpringAdapterResource.class.getName());

	@Context
	HttpServletRequest httpRequest;
	// Inject the MFP configuration API:
	@Context
	ConfigurationAPI configApi;

	@Autowired
	CustomerService customerService;

	/*
	 * Path for method:
	 * "<server address>/mfp/api/adapters/mySpringXmlAdapter/resource"
	 */

	@ApiOperation(value = "Returns 'Hello from resource'", notes = "A basic example of a resource returning a constant string.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Hello message returned") })
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getResourceData() {
		// log message to server log
		logger.warning("Logging info message...");
		System.out.println("hung");
		return "Hello from resource";
	}

	@GET
	@Path("/customer")
	@OAuthSecurity(scope = "test")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCustomer() {
		String authTokenHeader = httpRequest.getHeader("Authorization");
		System.out.println("authTokenHeader: " + authTokenHeader);
		return customerService.getCustomer(authTokenHeader);
	}


	@GET
	@Path("/unprotected")
	@Produces(MediaType.TEXT_PLAIN)
	@OAuthSecurity(enabled = false)
	public String unprotected() {
		logger.info("hung");
		return "Hello from unprotected resource!";
	}

	@POST
	@Path("/test_auth01")
	@Produces(MediaType.APPLICATION_JSON)// tr??? v??? Json
	@Consumes(MediaType.APPLICATION_JSON)// ?????u v??o ki???u Json
	@OAuthSecurity(scope = "read")
	public JSONObject jsonComsumerExample(ConsumersRequest request) {
		JSONObject data = new JSONObject();
		data.put("key", request.getName());
		return data;
	}

	@POST
	@Path("/test_auth02")
	@Produces(MediaType.APPLICATION_JSON)// tr??? v??? Json
	@Consumes(MediaType.APPLICATION_JSON)// ?????u v??o ki???u Json
	@OAuthSecurity(enabled = true)
	public JSONObject jsonComsumerExample02(ConsumersRequest request) {
		JSONObject data = new JSONObject();
		data.put("key", request.getName());
		return data;
	}
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)// ?????u v??o ki???u Json
	@OAuthSecurity(enabled = false)
	public JSONObject login(LoginRequest request) {
		return customerService.login(request);
	}

}
