package com.l.chat_qunliao;

import java.io.Closeable;

/**
 * ������
 * @author Ice
 *
 */
public class Utils {
//�ͷ���Դ
	public static void close(Closeable ... targets) {
		for(Closeable target : targets) {
			try {
				if(null != target) {
					target.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
