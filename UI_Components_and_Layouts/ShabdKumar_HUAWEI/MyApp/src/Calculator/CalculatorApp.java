package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

	private static Scanner in;

	public static void Calculator(){
		
		in = new Scanner(System.in);
		
		System.out.println("\nEnter the 1st Number :");
		int num1;
		while (true) {
			try {
				num1 = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not a Character :");
				in.nextLine();
				continue;
			} 
		}
		
		System.out.println("Enter the 2nd Number :");
		int num2;
		while (true) {
			try {
				num2 = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not the Character :");
				in.nextLine();
				continue;
			} 
		}
		
		System.out.println("\nEnter the Choice of Operation :");
		int ch;
		while (true) {
			try {
				ch = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter a number Not the Character :");
				in.nextLine();
				continue;
			} 
		}
		
		switch(ch){
			case 1 :int sum = num1 + num2;
					System.out.println("\nAddition of "+num1+" and "+num2+" = "+sum);
					break;
					
			case 2 :int diff;
					if (num1>num2)
						diff = num1 + num2;
					else
						diff = num2 - num1;
					System.out.println("\nDifference of "+num1+" and "+num2+" = "+diff);
					break;
					
			case 3 :long mul = num1 * num2;
					System.out.println("\nMultiplication of "+num1+" and "+num2+" = "+mul);
					break;
					
			case 4 :int div = num1 / num2;
					System.out.println("\nQuotient, we get from division of "+num1+" and "+num2+" = "+div);
					break;
					
			case 5 :int mod = num1 % num2;
					System.out.println("\nRemainder, we get from division of "+num1+" and "+num2+" = "+mod);
					break;
					
			default:System.out.println("\nWrong Choice.");
		}
		
		System.out.println("\n\nWanna go for Another Operation (1 for 'Yes'/ 0 for 'No') :");
		int choice;
		while (true) {
			try {
				choice = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter 1 or 0 :");
				in.nextLine();
				continue;
			} 
		}
		
		if (choice==1) {
			Calculator();
		}
		else{
			System.out.println("\nThanks for using MyApp");
			System.out.println("**********************");
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Calculator Operations");
		System.out.println("---------------------");
		System.out.println("| 1. Addition       |");
		System.out.println("| 2. Subtraction    |");
		System.out.println("| 3. Multiplication |");
		System.out.println("| 4. Division       |");
		System.out.println("| 5. Modulus        |");
		System.out.println("---------------------");
		
		Calculator();
	}

}
