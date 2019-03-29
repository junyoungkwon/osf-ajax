package test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

class Person {
	private Double key;
	private Integer key2;

	public Integer getKey2() {
		return key2;
	}

	public void setKey2(Integer key2) {
		this.key2 = key2;
	}

	public Double getKey() {
		return key;
	}

	public void setKey(Double key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Person [key=" + key + ", key2=" + key2 + "]";
	}

}

public class Exam01 {

	public static void main(String[] args) {
		String jsonStr = "{\"key2\":1}";
		String jsonStr2 = "[{\"key\":1},{\"key2\":2}]";
		String jsonStr3 = "{\"key\":1,\"key2\":2}";
		Gson g = new Gson();
		Gson g2 = new Gson();
		Gson g3 = new Gson();
		
		Map<String, Double> m = g.fromJson(jsonStr, Map.class);
		List<Map<String, Double>> m2 = g2.fromJson(jsonStr2, List.class);
		Person p = g3.fromJson(jsonStr3, Person.class);
		
		System.out.println(m2);
		System.out.println(m);
		System.out.println(p);
	}
}
