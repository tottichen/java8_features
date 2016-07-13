package me.totti.example.functional.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: FibonacciStream.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 10:50 <br>
 *
 * @author TottiChen
 */
public class FibonacciStream {
	static class FibonacciSupplier implements Supplier<Long> {
		long a = 0;
		long b = 1;

		@Override
		public Long get() {
			long x = a + b;
			a = b;
			b = x;
			return a;
		}
	}

	public static void main(String[] args) {
		Stream<Long> fibonacciStream = Stream.generate(new FibonacciSupplier());
		fibonacciStream.skip(20).limit(10).forEach(System.out::println);

		System.out.println("===========");

		fibonacciStream = Stream.generate(new FibonacciSupplier());
		List<Long> fibonaccis = new ArrayList<Long>(10);
		fibonaccis = fibonacciStream.limit(10).collect(Collectors.toList());
		for (long i : fibonaccis) {
			System.out.println(i);
		}
	}
}
