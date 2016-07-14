package me.totti.example.datetime;

import java.time.Clock;

/**
 * Title: ClockCase.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 16:10 <br>
 *
 * @author TottiChen
 */
public class ClockCase {
	public static void main(String[] args) {
		Clock clock = Clock.systemUTC();

		System.out.println(clock.instant());
		System.out.print(clock.millis());
	}
}
