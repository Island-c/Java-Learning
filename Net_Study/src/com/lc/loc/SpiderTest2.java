package com.lc.loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 爬虫 + 模拟浏览器
 * @author Trail
 *
 */
public class SpiderTest2 {
	public static void main(String[] args) throws IOException {
		//获取URL
		URL url=new URL("https://www.jd.com");
		//下载资源
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg =null;
		while(null != (msg = br.readLine()))
		{
			System.out.println(msg);
		}
		br.close();
		
	}
}
