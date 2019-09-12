package com.lc.server.core;
/**
 * 服务器小脚本接口
 * @author Ice
 *
 */
public interface Servlet {
	void service(Request request,Response response);
}
