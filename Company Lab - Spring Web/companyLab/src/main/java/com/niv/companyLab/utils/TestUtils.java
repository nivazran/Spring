package com.niv.companyLab.utils;

public class TestUtils {

	private static int count = 1;

	public static void testInfo(String content) {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println(String.format("      Test #%d : %s           ", count++, content));
		System.out.println("----------------------------------------------");
		System.out.println();
	}
}
