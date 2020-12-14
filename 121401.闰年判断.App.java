package pkg;

import java.util.Scanner;

public class App {
public static void main(String[] args) {
	
	
	while (true) {
		Scanner scanner =new Scanner(System.in);
		int year=scanner.nextInt();
		
		if(year!=0 && year%4==0 && year%100!=0) {
			System.out.println("该年份是闰年");
		}else if (year!=0 && year%400==0) {
			System.out.println("该年份是闰年");
		}
		else if (year!=0 && year%4==1) {
			System.out.println("该年份是闰年");
		}
		else if (year!=0 && year%400==1) {
			System.out.println("该年份是闰年");
		}
		
		else {
			System.out.println("该年份不是闰年");
		}
		
		
	}
	
} 


}
