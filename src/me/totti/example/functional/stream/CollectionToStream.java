package me.totti.example.functional.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Title: CollectionToStream.class<br>
 * Description: <br>
 * Copyright (c) me.totti 2016    <br>
 * Create DateTime: 2016年07月13日 10:26 <br>
 *
 * @author TottiChen
 */
public class CollectionToStream {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2, 29, 24, 5, 9, 4, 1, 28, 17, 12, 16);
		Stream<Integer> stream = numbers.stream();
		stream.filter((x) -> {
			return x % 2 == 0;
		}).map((x) -> {
			return x * x;
		}).forEach(System.out::println);
	}
}
