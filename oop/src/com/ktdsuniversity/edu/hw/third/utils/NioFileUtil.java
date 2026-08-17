package com.ktdsuniversity.edu.hw.third.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NioFileUtil {

	private static final String BASE_DIR = "library_data";

	public static void initDirectory() {
		try {
			Path path = Paths.get(BASE_DIR);
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static List<String> readFile(String fileName) {
		Path path = Paths.get(BASE_DIR, fileName);
		if (!Files.exists(path)) {
			return new ArrayList<>();
		}
		try {
			return Files.readAllLines(path);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void writeFile(String fileName, List<String> lines) {
		Path path = Paths.get(BASE_DIR, fileName);
		try {
			// CREATE: 파일이 없으면 새로 만든다
			// TRUNCATE_EXISTING: 파일이 이미 존재하면 안의 내용을 전부 지우고 처음부터 새로 쓴다
			Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
