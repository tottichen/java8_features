package me.totti.example.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Title: ParallelArrays.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 17:02 <br>
 *
 * @author TottiChen
 */
public class ParallelArrays {
	public static void main(String[] args) {
		long[] arrayOfLong = new long[20000];

		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);
        System.out.println();
	}
}
