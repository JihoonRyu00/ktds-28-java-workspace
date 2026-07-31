package com.ktdsuniversity.edu.oop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NIOWriteTest {

	public static void main(String[] args) {

//		for (int i = 99; i > 0; --i) {

		File targetFile = new File("C:/java/outputs", "java_output.txt");
		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

//		int index = 2;
//		while (targetFile.exists()) {
//			targetFile = new File(targetFile.getParent(), "java_output (%d).txt".formatted(index++));
//		}

//		try {
//			targetFile.createNewFile();
//		} catch (IOException ioe) {
//			// TODO Auto-generated catch block
//			ioe.printStackTrace();
//		}

		// 파일 생성 후 쓰기
		List<String> data = new ArrayList<>();
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		data.add("ASSASFASFFDAAAAAAAAAAA");
		try {
			Files.write(targetFile.toPath(), data, StandardOpenOption.APPEND);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
//		}
	}
}
