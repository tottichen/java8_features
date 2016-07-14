package me.totti.example.datetime;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Title: ZonedDateTimeCase.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 16:41 <br>
 *
 * @author TottiChen
 */
public class ZonedDateTimeCase {
	public static void main(String[] args) {
		Clock clock = Clock.systemUTC();

		final ZonedDateTime zonedDateTime = ZonedDateTime.now();
		final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
		final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Chicago"));

		System.out.println(zonedDateTime);
		System.out.println(zonedDateTimeFromClock);
		System.out.println(zonedDateTimeFromZone);
	}
}
