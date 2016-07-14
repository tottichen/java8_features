package me.totti.example.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Title: Base64Case.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 16:58 <br>
 *
 * @author TottiChen
 */
public class Base64Case {
	public static void main(String[] args) {
		String text = "Base64 finally in Java8!";

		String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);

		String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		System.out.println(decoded);
	}
}
