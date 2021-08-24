/*
 *  Licensed Materials - Property of IBM
 *  5725-I43 (C) Copyright IBM Corp. 2011, 2016. All Rights Reserved.
 *  US Government Users Restricted Rights - Use, duplication or
 *  disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

/**
 * @param tag: a topic such as MobileFirst_Platform, Bluemix, Cordova.
 * @returns json list of items.
 */

function getFeed() {
	var input = {
	    method : 'get', // method http
	    returnedContentType : 'json', // kiểu dữ liệu mà api được gọi trả về
	    path : "mfp/api/adapters/JavaAdapter/api/test_json" // link api 
	};

	return MFP.Server.invokeHttp(input);
}

function getTestJson() {
	
	var input = {
		adapter : 'JavaAdapter', // method http
		procedure : 'api/test_json', // API của Adapter khác ở đây là JavaAdapter
		parameted :[]
	};
	return MFP.Server.invokeProcedure(input);
}

function getTestJsonHasParameters() {
	var name = "name"
	var input = {
			method : 'post', // method http
		    returnedContentType : 'json', // kiểu dữ liệu mà api được gọi trả về
		    path:"mfp/api/adapters/JavaAdapter/api/path_param/"+name
	};
	return MFP.Server.invokeHttp(input);
}

/**
 * @returns ok
 */
function unprotected(param) {
	return {result : "Hello from unprotected resource"};
}