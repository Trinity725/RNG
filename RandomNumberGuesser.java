/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 09/29/2022
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Trinity Martin
*/


import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int low=1 , high = 100, next, value;
		String response, neededAnswer="yes";
		
		RNG a = new RNG();
		
		System.out.println("This application generates a random"
				+ " interger between 1 and 100");
		System.out.println("then asks the user to guess repeatedly"
				+ " until they guess correctly.\n");
		
		do
		{
			value= RNG.rand();
			
			//To know what value the program is looking for
			System.out.println(value);
			
			System.out.println("Enter your first guess:");
			next = keyboard.nextInt();
			
			if (next != value)
			{
				while  (a.getCount()<8 && next!= value)
				{
					if(next > value)
					{
						System.out.println("\nYour guess is too high");
						
						high= next-1;
					}
									
					if(next < value) 
					{
						System.out.println("\nYour guess is too low");
						
						low = next+1;
					}
				
				System.out.println("Number of guesses: " + a.getCount()+"\n");
				
				RNG.inputValidation(next, low, high);
				System.out.println("\nEnter your next guess between "+ low +" and "+ high+ ":");
								
				next = keyboard.nextInt();
				}	
				
			}
			if (next != value)
			{
				System.out.println("You've exceeded the maximum amount of attempts.\n");
			}
			
			if (next == value)	
			{
				System.out.println("\nCongratulations! You've guessed correctly!!!");
			}
			
			a.resetCount();
			high = 100;
			low = 1;
			System.out.println("Try Again? (yes or no)");
			
			response=keyboard.next();
			
		}while (response.equalsIgnoreCase(neededAnswer));
		
		System.out.println("\nThanks For Playing!");
	

	}

}
