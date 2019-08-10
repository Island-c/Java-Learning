package com.lc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 实现callable接口，重写call方法。
 * @author Trail
 *
 */
public class CDownloader implements Callable<Boolean> {

	private String url;
	private String name;
	CDownloader(String u , String n){
		url=u;
		name=n;
	}
	@Override
	public Boolean call() throws Exception{
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader  td1 = new CDownloader("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1565405151&di=273733229277e4420de5791ee6031200&src=http://science.china.com.cn/images/attachement/jpg/site555/20150731/e89a8ffb139317251fea42.jpg","baidu.jpg");
		CDownloader  td2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=d4acfa5d58cf474d9d0dc01f940b86e3&imgtype=0&src=http%3A%2F%2Fimg001.hc360.cn%2Fm6%2FM04%2FCB%2F8F%2FwKhQoVYrRo-EJF8uAAAAANgFb9Y290.jpg","baidu2.jpg");
		CDownloader  td3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=cec03ac7cf82ebec0be79f719da9af16&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","baidu3.jpg");
		
		//创建执行服务
		ExecutorService ser=Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> result1=ser.submit(td1);
		Future<Boolean> result2=ser.submit(td2);
		Future<Boolean> result3=ser.submit(td3);
		//获取结果
		boolean r1=result1.get();
		boolean r2=result2.get();
		boolean r3=result3.get();
		//关闭服务
		ser.shutdownNow();
	}
}
