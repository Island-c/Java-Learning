package others;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务定时调度。
 * @author Trail
 *
 */
public class TimerTest1 {
	public static void main(String[] args) {
 
	}	
}

class MyTask extends TimerTask{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<10 ; i++) {
			System.out.println("休息");
		}
		System.out.println("-------------");
	}
	
	
}