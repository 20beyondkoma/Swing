package pkg;

import java.math.BigInteger;

public class App2 {

	public static void main(String[] args) {
 
		long sum=0;

		for (long i = 1; i <= 2147483647; i++) {
			if(i%2==1) {
			sum=(sum+i);
			}
		
		}
		System.out.println("1-2147483647的奇数和="+sum);
		
	}
}

//121402.奇数求和.App.java
