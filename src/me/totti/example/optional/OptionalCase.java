package me.totti.example.optional;

import java.util.Optional;

/**
 * Title: OptionalCase.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 10:44 <br>
 *
 * @author TottiChen
 */
public class OptionalCase {
	public static void main(String[] args) {
		Optional<String> fullName = Optional.ofNullable(null);
		System.out.println("Full Name is set?" + fullName.isPresent());
		System.out.println("Full Name:" + fullName.orElseGet(() -> "[none]"));
		// 针对Optional为空时,map将不起作用
		System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

		Optional<String> firstName = Optional.of("Totti");
		System.out.println("First Name is set?" + firstName.isPresent());
		System.out.println("First Name:" + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s).orElse("Hey Stranger!"));
	}
}
