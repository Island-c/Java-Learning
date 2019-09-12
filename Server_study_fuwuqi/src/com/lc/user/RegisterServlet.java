package com.lc.user;

import com.lc.server.core.Request;
import com.lc.server.core.Response;
import com.lc.server.core.Servlet;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request,Response response) {
		// TODO Auto-generated method stub
		//关注业务逻辑
		String uname= request.getParameter("uname");
		String[] favs = request.getParametervalues("fav");
		//System.out.println(uname+" -------");
		response.print("注册成功");
		response.print("你注册的信息为："+uname);
		response.print("你选择的类型为：");
		for(String v : favs) {
			if(v.equals("0")) {
				response.print("luo");
			}
			else if(v.equals("1")){
				response.print("haofang");
			}else if(v.equals("2")){
				response.print("jieyue");
			}
		}
	}
}
