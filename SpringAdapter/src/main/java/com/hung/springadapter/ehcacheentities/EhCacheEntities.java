package com.hung.springadapter.ehcacheentities;

import com.ibm.json.java.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EhCacheEntities {

	private Object tokenAuth;
	private Object tokenMfp;
}
