package com.ktdsuniversity.edu.oop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class NIOReadTest {

	public static void main(String[] args) {

		File textFile = new File("C:\\Java Exam", "Java Exam.txt");

		// 파일을 읽어서 출력
		if (textFile.exists() && textFile.isFile()) {
			List<String> lines = null;
			try {
				lines = Files.readAllLines(textFile.toPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			if (lines != null) {
				for (String s : lines) {
					System.out.println(s);
				}
			}
		}
	}
}
