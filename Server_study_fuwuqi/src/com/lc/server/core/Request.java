package com.lc.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求协议 1. 获取method uri以及请求参数 2. 封装请求参数为Map
 * 
 * @author Ice
 *
 */
public class Request {

	private String requestInfo;

	private String method; // request method

	private String url; // request url

	private String queryStr; // requer parameters

	private Map<String, List<String>> parameterMap;

	private final String CRLF = "\r\n";

	public Request(InputStream is) {
		parameterMap = new HashMap<String, List<String>>();

		byte[] datas = new byte[1024 * 1024*1024];
		int len;
		try {
			len = is.read(datas);
			System.out.println(len);
			this.requestInfo = new String(datas, 0, len);
			
		} catch (IOException e) {
			System.out.println("error");
			return;
		}
		System.out.println(requestInfo);
		System.out.println();
		// division String
		parseRequestInfo();

	}

	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}

	private void parseRequestInfo() {
		System.out.println("-----division----------");
		System.out.println("------1.get request method---:from begin to first /--");
		this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase().trim();
		System.out.println(method);
		System.out.println("------1.get url---:from first / to HTTP/--");
		System.out.println("------maybe conclude request parameters.depend on ? , befor it is url--");
		// 1. get first /
		int startldx = this.requestInfo.indexOf("/") + 1;
		// 2. get HTTP/
		int endldx = this.requestInfo.indexOf("HTTP/");
		// 3. split String
		this.url = this.requestInfo.substring(startldx, endldx).trim();
		System.out.println("url: "+this.url);
		// 4.get the index of '?'
		int queryldx = this.url.indexOf("?"); // if ==-1 ,inexistence ; else esist, return index.
		if (queryldx >= 0) {
			// there is a "?"
			String[] urlArray = this.url.split("\\?");
			this.url = urlArray[0];
			queryStr = urlArray[1];
		}

		System.out.println("--3.get request parameters:  if GET already got it ; if post, maybe in request body---");

		if (method.equals("post")) {
			String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if (null == queryStr)
				queryStr = "";
			else {
				queryStr += "&" + qStr;
			}

		}
		
		// convert to Map
		// Map fav=1&fav=2&uname=lc&age=18&others= (the name of key maybe equal. 1 to n)
		if (queryldx >= 0) 
			convertMap();

	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getQueryStr() {
		return queryStr;
	}

	// convert parameters to Map
	private void convertMap() {
		String[] keyValues = queryStr.split("&");
		for (String queryStr : keyValues) {
			// split : "="
			String[] kv = queryStr.split("=");
			kv = Arrays.copyOf(kv, 2); // if meet others= , revert to (others=0)
			// get key&value
			String key = kv[0];
			String value = kv[1] == null ? null : decode(kv[1], "UTF-8");
			// put map
			if (!parameterMap.containsKey(key)) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
			System.out.println(key + "   " + value);
		}
	}

	public String[] getParametervalues(String key) {
		List<String> values = this.parameterMap.get(key);

		if (null == values || values.size() < 1) {
			return null;
		}
		return values.toArray(new String[0]); // String type
	}

	public String getParameter(String key) {
		String[] values = getParametervalues(key);
		System.out.println(values[0]);
		return values == null ? null : values[0];
	}

	// process Chinese
	private String decode(String value, String enc) {
		try {
			return java.net.URLDecoder.decode(value, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
