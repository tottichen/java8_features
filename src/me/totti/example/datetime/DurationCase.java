package me.totti.example.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Title: DurationCase.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 16:45 <br>
 *
 * @author TottiChen
 */
public class DurationCase {
	public static void main(String[] args) {
		LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59, 59);

		final Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.print("Duration in hour: " + duration.toHours());
	}
}
