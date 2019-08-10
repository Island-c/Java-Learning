package com.lc.thread;

public class IDownloader2 implements Runnable {

	private String url;
	private String name;
	IDownloader2(String u , String n){
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
		IDownloader2  td1 = new IDownloader2("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1565405151&di=273733229277e4420de5791ee6031200&src=http://science.china.com.cn/images/attachement/jpg/site555/20150731/e89a8ffb139317251fea42.jpg","baidu.jpg");
		IDownloader2  td2 = new IDownloader2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=d4acfa5d58cf474d9d0dc01f940b86e3&imgtype=0&src=http%3A%2F%2Fimg001.hc360.cn%2Fm6%2FM04%2FCB%2F8F%2FwKhQoVYrRo-EJF8uAAAAANgFb9Y290.jpg","baidu2.jpg");
		IDownloader2  td3 = new IDownloader2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565415232554&di=cec03ac7cf82ebec0be79f719da9af16&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","baidu3.jpg");
		
		//启动三个线程
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}
