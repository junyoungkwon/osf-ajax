package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ttest {

	public static void main(String[] args) {
		List<Map<String,String>> list = new ArrayList<>();
		Map<String,String> map = new HashMap<>();
		map.put("name","홍길동");
		list.add(map);
		System.out.println(list);
		map.put("name", "김길동");
		System.out.println(list);
		
		
		
	}
	
	
}
