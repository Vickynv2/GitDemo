package rahulshettyacademy.tests;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsInJava {

	public static void main(String[] args) {
		String inputString = "Welcome to TCS";
		String[] words=inputString.split(" ");
		Collections.reverse(Arrays.asList(words));
		String outputString = String.join(" ", words);
		System.out.println(outputString);

	}

}
