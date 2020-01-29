package com.example.demo.junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;



public class WebServiceTest {
	@Test
	public void getPoint() {
//		Point p = new PointService().getPointPort();
//		p.add(1, 2);
//		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer t = iterator.next();
			iterator.remove();
			System.out.println(t);
		}
		System.out.println(list);
	}
}





