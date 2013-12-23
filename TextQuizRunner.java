/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
   %                                                                     %
   %                   This program copyright 2012                       %
   %                            Joseph May                               %
   %                                                                     %
   %                       All Rights Reserved                           %
   %                                                                     %
   %                                                                     %
   %                                                                     %
   %                                                                     %
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
*/

package quizIt;

import java.util.ArrayList;
import java.util.Scanner;


//This is my original text-based program... at this point it's basically gutted
public class TextQuizRunner {

	//arraylist creates a deck of flash cards
	private static ArrayList<Cards> flashDeck = new ArrayList<Cards>();
	private static ArrayList<Cards> flashDeckHolder = new ArrayList<Cards>();
	private static ArrayList<Cards> flashDeckHolder2 = new ArrayList<Cards>();
	private static ArrayList<Cards> randomizedFlashDeck = new ArrayList<Cards>();
	
	//building the sample set of flashcards, this method probably won't exist (as is) 
	//in the final version of the project
	public static void createDeck()
	{
	flashDeck.add(new Cards("Cat", "A furry animal"));
	flashDeck.add(new Cards("Apple", "A round, red fruit"));
	flashDeck.add(new Cards("Chair", "What you sit in"));
	flashDeck.add(new Cards("Eyes", "What you see out of"));
	}
	
	public static void randomizeArraylist( ArrayList<Cards> aDeck )
	{
		int p = 0;
		while ( p< aDeck.size())
		{
			flashDeckHolder2.add(aDeck.get(p));
			p++;
		}
	
		p = 0;
		while (p< flashDeckHolder2.size())
		{
		int q = (int) (Math.random() * flashDeckHolder2.size()); 
		randomizedFlashDeck.add(flashDeckHolder2.get(q));
		flashDeckHolder2.remove(q);
	
		
		}
		
		flashDeckHolder.clear();
		p = 0;
		while ( p< randomizedFlashDeck.size())
		{
			flashDeckHolder.add(randomizedFlashDeck.get(p));
			p++;
		}
		
	}
	
	public static void main (String []args)
	{

		createDeck();
		randomizeArraylist(flashDeck);
		System.out.println("Please capatalize first word!");
		//k is set to 1 so that the first round will begin
		int k = 1;
		//right is declared outside the loop in order to keep the value totaling 
		//across all rounds, while the number gotten wrong is refreshed each round
		int right = 0;
		// if any were wrong in the last round, starts a new round
		while(k!=0)
		{
		int wrong = 0;
		//k is set to zero so no more rounds will occur unless some number of terms 
		//are gotten wrong
		k = 0;
		int i = flashDeckHolder.size();
		int j = 0;
		//loops through each term
		while (j < i)
		{
			randomizeArraylist(flashDeckHolder);
			if (!flashDeckHolder.get(j).returnRight())
			{
			System.out.println("Correct [" + right + "]       Incorrect [" + wrong + "]");
			System.out.println("What word means " + flashDeckHolder.get(j).returnDefinition());
			
			String stringHolder = new Scanner(System.in).nextLine();
			
			if (stringHolder.equals(flashDeckHolder.get(j).returnTerm()))
			{
				System.out.println("Correct!");
				flashDeckHolder.get(j).setRight();
				//for (int count = 0; count < 20; count++)
					System.out.println();
				right++;
				
			}
			else
			{
				System.out.println("Wrong!");
				//for (int count = 0; count < 20; count++)
					System.out.println();
				k++;
				wrong++;
			}
			}
			j++;
		}
		if (k != 0)
		{
			System.out.println("New Round starts now!");
			
		}
		
		if (k == 0)
			System.out.println("You have gotten all of the words correct!");
		}
		
	}
	
}
