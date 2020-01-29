package com.example.demo.bean;

import java.util.Calendar;
import java.util.Date;

public class StudyDay02 {
	public static void main(String[] args) {
		System.out.println(args.toString());
		Date date = new Date(new Date().getTime());
		System.out.println(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if(1==dayOfWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()- day);
		System.out.println(cal.getTime());
		System.out.println(day);
//		Scanner scan = new Scanner(System.in);
//		int all = 0;
//		System.out.println("获取输入数字的平方");
//		while(scan.hasNextInt()) {
//			int i = scan.nextInt();
//			all = i * i;
//			System.out.println(all);
//		}
		
	}
}
