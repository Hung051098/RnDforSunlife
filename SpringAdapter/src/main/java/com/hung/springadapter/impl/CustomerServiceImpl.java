package com.hung.springadapter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.hung.springadapter.cache.EhCache;
import com.hung.springadapter.data.Customer;
import com.hung.springadapter.ehcacheentities.EhCacheEntities;
import com.hung.springadapter.request.LoginRequest;
import com.hung.springadapter.service.CustomerService;
import com.ibm.json.java.JSONObject;

public class CustomerServiceImpl implements CustomerService {

	static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	EhCache ehcache;
//	@Autowired
//	LoginMapIntf map;

	@Override
	public JSONObject getCustomer(String authTokenHeader) {
		Customer cus = new Customer();
		for (int i = 0; i < 5; i++) {
			ehcache.putCustomerToCache();
			System.out.println("email: " + cus.getEmail());
		}
		JSONObject data = new JSONObject();
		data.put("data", cus.getEmail());
		return data;
	}

	@Override
	public JSONObject login(LoginRequest re) {
		JSONObject data = new JSONObject();
		try {
			String url = "http://localhost:9080/mfp/api/az/v1/token";
		    CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			List <NameValuePair> params = new ArrayList <NameValuePair>();
			params.add(new BasicNameValuePair("grant_type", "client_credentials"));
			params.add(new BasicNameValuePair("scope", re.getScope()));
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			
			
			UsernamePasswordCredentials creds
		      = new UsernamePasswordCredentials(re.getUsername(), re.getPassword());
		    try {
				httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
			
			
		    CloseableHttpResponse response = client.execute(httpPost);

			HttpEntity entity = response.getEntity();
		    if (entity != null) {
		        String result = EntityUtils.toString(entity);
		        org.json.JSONObject obj = new org.json.JSONObject(result);
		        System.out.println(result);
		        org.json.JSONObject objAuthServer = this.loginAuthorizationServer(re);
				System.out.println("en =access_token====>: "+ objAuthServer.get("access_token"));
//				for (int i = 0; i < 5; i++) {
					EhCacheEntities en = ehcache.loadToCache(obj.get("access_token"), objAuthServer.get("access_token"));
					System.out.println("en ======>: " + new Gson().toJson(en));
//				}
				data.put("access_token", obj.get("access_token"));
				data.put("token_type", obj.get("token_type"));
				data.put("expires_in", obj.get("expires_in"));
				data.put("scope", obj.get("scope"));
		    }
		    client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private org.json.JSONObject loginAuthorizationServer(LoginRequest re)
	{
		org.json.JSONObject data = new org.json.JSONObject();
		try {
			String url = "http://localhost:9191/oauth/token";
		    CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			List <NameValuePair> params = new ArrayList <NameValuePair>();
			params.add(new BasicNameValuePair("grant_type", "password"));
			params.add(new BasicNameValuePair("username", re.getUsername()));
			params.add(new BasicNameValuePair("password", re.getPassword()));
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			
			
			UsernamePasswordCredentials creds
		      = new UsernamePasswordCredentials("mobile", "pin");
		    try {
				httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
			
			
		    CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				System.out.println(result);
				data = new org.json.JSONObject(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
