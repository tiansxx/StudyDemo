package com.tian.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecutor {

	public static String executeCommand(String command, boolean waitForResponse) {
		String response = "";
		String os = System.getProperty("os.name");
		ProcessBuilder pb = null;
		if (os.toLowerCase().contains("window")) {
			pb = new ProcessBuilder("cmd", "/c", command);
		} else {
			pb = new ProcessBuilder("/bin/bash", "-c", command);
		}

		pb.redirectErrorStream(true);

		try {
			Process shell = pb.start();
			if (waitForResponse) {
				// To capture output from the shell
				InputStream shellIn = shell.getInputStream();
				// Wait for the shell to finish and get the return code
				response = convertStreamToStr(shellIn);
				shellIn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	private static String convertStreamToStr(InputStream is) throws IOException {

		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	
	public static void parseResult(String output) {
		Pattern p = Pattern.compile("(KiB )?Mem(\\s)?:\\s(.*)\\stotal,\\s(.*)\\sfree,\\s(.*)\\sused,\\s(.*)");
		Matcher m = p.matcher(output);
		if (m.matches()) {
			System.out.println(m.group(4));
			System.out.println(m.group(5));
		}
	}
	
	public static void main(String[] args) {
		String dirRequest = "top -b -n 1 | grep -i mem";
		String output = executeCommand(dirRequest, true);
		parseResult(output);
	}
	
}
