package me.totti.example.functional.lambda;

/**
 * Title: RunableThreadLambda.class<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年07月13日 15:55 <br>
 *
 * @author TottiChen
 */
public class RunableThreadLambda {
	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("test");
		}).start();
	}
}
