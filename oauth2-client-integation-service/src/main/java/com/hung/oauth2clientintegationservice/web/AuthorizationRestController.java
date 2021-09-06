/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hung.oauth2clientintegationservice.web;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Joe Grandja
 * @since 0.0.1
 */
@RestController
public class AuthorizationRestController {
	private final WebClient webClient;
//	private final String messagesBaseUri;

	public AuthorizationRestController(WebClient webClient/*,
			@Value("${messages.base-uri}") String messagesBaseUri*/) {
		this.webClient = webClient;
//		this.messagesBaseUri = messagesBaseUri;
	}

	@GetMapping(value = "/authorize2", params = "grant_type=authorization_code")
	public JSONObject authorizationCodeGrant(
			@RegisteredOAuth2AuthorizedClient("messaging-client-authorization-code")
					OAuth2AuthorizedClient authorizedClient) {
		JSONObject data = new JSONObject();
		try {
			sendGet(data, "http://127.0.0.1:10006/customer/list_customer", authorizedClient.getAccessToken().getTokenValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}


    private final CloseableHttpClient httpClient = HttpClients.createDefault();
	private JSONObject sendGet(JSONObject data, String url, String token) throws Exception {
        HttpGet request = new HttpGet(url);

        // add request headers
        request.addHeader("Authorization", "Bearer "+token);

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            data.put("value", entity);
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                data.put("value", result);
                System.out.println(result);
            }

        }
        return data;
    }
}
