package rahulshettyacademy.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapInJava {

	public static void main(String[] args) {
		Map<String , Integer> studentGrades = new LinkedHashMap<>();
		studentGrades.put("venkat", 95);
		studentGrades.put("ravi", 85);
		studentGrades.put("ajay", 86);
		
		int raviGrade=studentGrades.get("ravi");
		System.out.println(raviGrade);
		for(String name:studentGrades.keySet())
		{
			int grade=studentGrades.get(name);
			System.out.println(name+"'s Grade: "+grade);
		}
		

	}

}
