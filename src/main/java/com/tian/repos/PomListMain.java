package com.tian.repos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;


public class PomListMain { 

	static String repoPath = "H:\\maven\\repository";
	static BufferedWriter br = null;
//	static String repoPath = "H:\\maven\\repository\\ant";

	public static void main(String[] args) {
		try {
			File output = new File("lib_release.txt");
			System.out.println(output.getAbsolutePath());
			br = new BufferedWriter(new FileWriter(output));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File repoDir = new File(repoPath);
		LinkedList<File> subDirList = getSubDirs(repoDir);
		for (File f : subDirList) {
			listRepos(f);
		}
		
		try {
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void listRepos(File path) {
		
		LinkedList<File> subDirList = getSubDirs(path);
		if (subDirList == null) {
			if (path.getName().endsWith("jar")) {
				String id = path.getParent().replaceAll("\\\\", ".").substring(20);
				String name = path.getName();
				try {
					br.write(id + "\t" + name + "\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return;
		}
		
		for (File f : subDirList) {
			listRepos(f);
		}
	}

	static LinkedList<File> getSubDirs(File dir) {
		File[] listFiles = null;
		if (dir.isDirectory()) {
			listFiles = dir.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					if (name.startsWith("-") || name.startsWith("."))
						return false;
					return true;
				}
			});
		}
		
		if (listFiles == null) 
			return null;
		LinkedList<File> dirList = new LinkedList<File>();
		for (File subDir : listFiles) {
			dirList.add(subDir);
		}
		
		return dirList;
		
	}
}

