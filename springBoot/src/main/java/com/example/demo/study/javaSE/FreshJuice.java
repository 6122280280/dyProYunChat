package com.example.demo.study.javaSE;


import java.util.ArrayList;
import java.util.List;


public class FreshJuice {
	private int m = 0;
	enum FreshJuiceSize{large, MIDDLE, small};
	FreshJuiceSize size = FreshJuice.FreshJuiceSize.MIDDLE;
	public static void main(String[] arg0) {
		 
		String[] orgArr = {"AB", "CD"};
		
		List<List<Object>> ll = new ArrayList<>();
		List<List<Object>> alll = new ArrayList<>();
		int aaa = 0;
		for(int i = 0;i < orgArr[0].length();i++) {
			List<Object> arrL = new ArrayList<>();
			arrL.add(orgArr[0].charAt(i));
			ll.add(arrL);
			aaa++;
		}
		alll = ll;
		System.out.println(">>" + ll);
		if(orgArr.length>1) {
			for(int i=1;i<orgArr.length;i++) {
				List<Object> arrN = new ArrayList<>();
				for(int j = 0;j < orgArr[i].length();j++) {
					for(int m=0;m<aaa;m++) {
						List<Object>nll = new ArrayList<>();
						nll = alll.get(m);
						nll.add(orgArr[i].charAt(j));
						ll.add(nll);
					}
				}
//				alll = ll;
			}
		}
		System.out.println(ll);
//		int mm = orgArr.length;
//		List<List<Object>> aa = new ArrayList<>();
//		List<Object>all = new ArrayList<>();
//		for(int j = 0;j < orgArr.length-1;j++) {
//			test(orgArr[j], orgArr[j+1], aa);
//		}
//		for(int s=0;s<aa.size();s++) {
//			
//			for(int w=aa.size()-1-(orgArr.length%2 * 2);w>aa.size()-5-(orgArr.length%2 * 2);w--) {
//				List<Object> list1 = new ArrayList<>();
//				for(int f=0;f<aa.get(s).size();f++) {
//					list1.add(aa.get(s).get(f));
//				}
//				for(int f=0;f<aa.get(w).size();f++) {
//					list1.add(aa.get(w).get(f));
//				}
//				all.add(list1);
//			}
//		}
//		System.out.println(all);
//		System.out.println(all.size());
//		System.out.println(aa);
	}
	static void test(String org,String org1, List<List<Object>> aa){
		List<Object> ss = new ArrayList<>();
		int k = 0;
		for(int i = 0;i < org.length();i++) {
			char c = org.charAt(i);
			
			int o = 0;
			for(int j = 0;j < org1.length();j++) {
				List<Object> mm = new ArrayList<>();
				mm.add(c);
				char d = org1.charAt(j);
				if(o == j) {
					mm.add(d);
					aa.add(mm);
				}else {
					mm.add(d);
					aa.add(mm);
				}
				o = j;
			}
		}
	}

}
class FreshJuiceTest implements Runnable{

	@Override
	public void run() {
		User u = new User(100);
		System.out.println(u.money);
	}
}
class User {
    int money;
	public User(int money) {
		this.money = money;
	}
	protected void finalize() throws Throwable {
		super.finalize();
		if(money == 100) {
			System.out.println(money);
		}else {
			System.out.println("200");
		}
	}
}