package me.totti.example;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Title: NaturalSupplierStream.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 10:43 <br>
 *
 * @author TottiChen
 */
public class NaturalStream {
	static class NaturalSupplier implements Supplier<Long> {
		long value = 0;

		public Long get() {
			this.value = this.value + 1;
			return this.value;
		}
	}

	public static void main(String[] args) {
		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		natural.map((x) -> {
			return x * x;
		}).limit(10).forEach(System.out::println);
	}
}
