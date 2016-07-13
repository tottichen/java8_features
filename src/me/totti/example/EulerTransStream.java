package me.totti.example;

import java.util.function.Function;
import java.util.stream.Stream;

import me.totti.example.supplier.PiSupplier;

/**
 * Title: EulerTransForm.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 14:08 <br>
 *
 * @author TottiChen
 */
public class EulerTransStream {
	static class EulerTransform implements Function<Double, Double> {

		double n1 = 0.0;
		double n2 = 0.0;
		double n3 = 0.0;

		@Override
		public Double apply(Double t) {
			n1 = n2;
			n2 = n3;
			n3 = t;
			if (n1 == 0.0) {
				return 0.0;
			}
			return calc();
		}

		double calc() {
			double d = n3 - n2;
			return n3 - d * d / (n1 - 2 * n2 + n3);
		}
	}

	public static void main(String[] args) {
		Stream<Double> piStream = Stream.generate(new PiSupplier());
		piStream.map(new EulerTransform()).limit(10).forEach(System.out::println);
	}
}
