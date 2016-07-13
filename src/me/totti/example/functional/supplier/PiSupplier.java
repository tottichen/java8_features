package me.totti.example.functional.supplier;

import java.util.function.Supplier;

/**
 * Title: PiSupplier.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 14:11 <br>
 *
 * @author TottiChen
 */
public class PiSupplier implements Supplier<Double> {

	double sum = 0.0;
	double current = 1.0;
	boolean sign = true;

	@Override
	public Double get() {
		sum += (sign ? 4 : -4) / this.current;
		this.current = this.current + 2.0;
		this.sign = !this.sign;
		return sum;
	}
}
