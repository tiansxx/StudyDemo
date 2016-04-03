package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpMain {

	public static void main(String[] args) {
		String s = "him hi HI history";
		Pattern p = Pattern.compile("\\bhi\\b", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		String output = null;
		while (m.find()) {
			output = String.format(("I found the text \"%s\" starting at index %d and ending at index %d.%n"),
                    m.group(),
                    m.start(),
                    m.end());
			System.out.println(output);
		}
	}
}
