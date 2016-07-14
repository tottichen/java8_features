package me.totti.example.functional.stream;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Title: FileStream.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 15:48 <br>
 *
 * @author TottiChen
 */
public class FileStream {
	public static void main(String[] args) throws URISyntaxException, IOException {
		final Path path = new File(FileStream.class.getResource("file.data").toURI()).toPath();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
		}
	}
}
