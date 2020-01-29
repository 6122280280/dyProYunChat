package com.example.demo.study.javaSE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class CollectionTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("asd");
		s.add("a");
		s.add("a");
		s.add("d");
		SortedSet<String> ss = new TreeSet<String>();
		ss.add("sd");
		ss.add("a");
		ss.add("sddd");
		System.out.println(ss);
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add(null);
		list.add("asdasd");
		Iterator<String> iterator = list.iterator();
		Map<String, Object> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		Set<String> set = map.keySet();
		Set<Entry<String, Object>>setm = map.entrySet();
		for(Entry<String, Object> entry:setm) {
			System.out.println(entry.getKey());
		}
		Iterator<Entry<String, Object>> iterator3 = setm.iterator();
		Iterator<String> iterator2 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next().getKey());
		}
		while(iterator2.hasNext()) {
			System.out.println(map.get(iterator2.next()));
		}
		System.out.println(list);
	}
}
