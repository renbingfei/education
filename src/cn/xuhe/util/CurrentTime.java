package cn.xuhe.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String today = sdf.format(date);
		return today;
	}
}
