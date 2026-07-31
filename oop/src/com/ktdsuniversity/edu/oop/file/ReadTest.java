package com.ktdsuniversity.edu.oop.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest {

	public static void main(String[] args) {

		// 읽고 싶은 파일 지정
		File textFile = new File("C:\\Java Exam", "Java Exam.txt");
		// 파일 존재하는지, 파일 형식인지 확인
		if (textFile.exists() && textFile.isFile()) {

			// 파일을 읽는 파이프
			FileReader fr = null;
			// 파일 청커 파이프
			BufferedReader br = null;

			try {
				// FileReader 인스턴스 생성
				fr = new FileReader(textFile);
				// BufferedReader 인스턴스 생성
				br = new BufferedReader(fr);
				// 파일을 한 줄 씩 읽어 출력
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
				// throws at FileReader()
			} catch (FileNotFoundException fnfe) {
				System.out.println(fnfe.getMessage());
				fnfe.printStackTrace();
				// throws at BufferedReader.readLine()
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
					}
				}
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}
}
