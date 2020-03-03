package com.yash.helper;

import java.util.Scanner;
import java.util.function.Supplier;

public class ScannerSupplier {
	private static Scanner scanner;

	public static Supplier<Scanner> getScannerSupplier() {

		return () -> {
			if (scanner == null) {
				scanner = new Scanner(System.in);
			}
			return scanner;
		};
	}
}
