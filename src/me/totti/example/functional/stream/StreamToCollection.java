package me.totti.example.functional.stream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: StreamToCollection.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 11:27 <br>
 *
 * @author TottiChen
 */
public class StreamToCollection {

	static class FibonacciSupplier implements Supplier<Long> {
		long value;

		@Override
		public Long get() {
			this.value = this.value + 1;
			return this.value;
		}
	}

	public static void main(String[] args) {
		Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
		List<Long> fibonacciValues = fibonacci.limit(10).collect(Collectors.toList());
		for (long value : fibonacciValues) {
			System.out.println(value);
		}
	}
}
