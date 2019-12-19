package com.lc.pojo;

import net.sf.cglib.proxy.Enhancer;

public class Women {


	public static void main(String[] args) {
		
		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(LaoZong.class);
		
		enhancer.setCallback(new MiShu());
		
		LaoZong create = (LaoZong)enhancer.create();
		create.chifan();
		
		
		
	}
}
