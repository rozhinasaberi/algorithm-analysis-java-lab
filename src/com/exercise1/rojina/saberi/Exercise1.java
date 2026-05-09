package com.exercise1.rojina.saberi;

public class Exercise1 {

	// ex1
	// big-Oh: O(n)
	// one loop runs from 1 to n. each iteration does O(1) work.
	public static int example1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}

	// ex2
	// big-Oh: O(n)
	// loop runs from 1 to 2n. drop the constant 2 -> O(n).
	public static int example2(int n) {
		int p = 1;
		for (int i = 1; i <= 2 * n; i++)
			p *= i;
		return p;
	}

	// ex3
	// big-Oh: O(n^2)
	// loop runs from 1 to n^2 -> O(n^2).
	public static int example3(int n) {
		int p = 1;
		for (int i = 1; i <= (int) Math.pow(n, 2); i++)
			p *= i;
		return p;
	}

	// ex4
	// big-Oh: O(n^2)
	// outer loop runs 2n times; inner runs 1..i.
	// total steps = 1 + 2 + ... + 2n = (2n)(2n+1)/2 = O(n^2).
	public static int example4(int n) {
		int sum = 0;
		for (int i = 1; i <= 2 * n; i++) {
			for (int j = 1; j <= i; j++)
				sum += i;
		}
		return sum;
	}

	// ex5
	// big-Oh: O(n^4)
	// outer loop runs n^2 times; inner runs 1..i.
	// total steps = 1 + 2 + ... + n^2 = (n^2)(n^2+1)/2 = O(n^4).
	public static int example5(int n) {
		int sum = 0;
		for (int i = 1; i <= (int) Math.pow(n, 2); i++) {
			for (int j = 1; j <= i; j++)
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		// Rojina Saberi
		// 301533334
		

		int n = 5; 

		System.out.println("n = " + n);
		System.out.println("example1: " + example1(n));
		System.out.println("example2: " + example2(n));
		System.out.println("example3: " + example3(n));
		System.out.println("example4: " + example4(n));
		System.out.println("example5: " + example5(n));
	}
}
