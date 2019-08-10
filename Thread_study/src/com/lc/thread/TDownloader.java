package com.lc.thread;

public class TDownloader extends Thread {

	private String url;
	private String name;
	TDownloader(String u , String n){
		url=u;
		name=n;
	}
	@Override
	public void run() {
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		TDownloader  td1 = new TDownloader("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1565405151&di=273733229277e4420de5791ee6031200&src=http://science.china.com.cn/images/attachement/jpg/site555/20150731/e89a8ffb139317251fea42.jpg","baidu.jpg");
		TDownloader  td2 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=d4acfa5d58cf474d9d0dc01f940b86e3&imgtype=0&src=http%3A%2F%2Fimg001.hc360.cn%2Fm6%2FM04%2FCB%2F8F%2FwKhQoVYrRo-EJF8uAAAAANgFb9Y290.jpg","baidu2.jpg");
		TDownloader  td3 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=cec03ac7cf82ebec0be79f719da9af16&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","baidu3.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}
