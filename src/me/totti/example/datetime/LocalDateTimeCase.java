package me.totti.example.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Title: LocalDateTimeCase.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 16:12 <br>
 *
 * @author TottiChen
 */
public class LocalDateTimeCase {
	public static void main(String[] args) {
		Clock clock = Clock.systemUTC();

		LocalDate localDate = LocalDate.now();
		LocalDate localDateFromClock = LocalDate.now(clock);

		System.out.println(localDate);
		System.out.println(localDateFromClock);

		LocalTime localTime = LocalTime.now();
		LocalTime localTimeFromClock = LocalTime.now(clock);

		System.out.println(localTime);
		System.out.println(localTimeFromClock);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTimeFromClock = LocalDateTime.now(clock);

        System.out.println(localDateTime);
        System.out.println(localDateTimeFromClock);
	}
}
