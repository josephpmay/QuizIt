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


//this class somewhat acts as the in-between between the different classes of my program- this is where 
//much of the action happens
public class QuizRunner {
	
	public QuizRunner()
	{

		
		randomizeArraylist(CardBank.returnLatest());
	}
	
	//arraylist creates a deck of flash cards
	private static ArrayList<Cards> flashDeck = new ArrayList<Cards>();
	private static ArrayList<Cards> flashDeckHolder = new ArrayList<Cards>();
	private static ArrayList<Cards> flashDeckHolder2 = new ArrayList<Cards>();
	private static ArrayList<Cards> randomizedFlashDeck = new ArrayList<Cards>();
	private static ArrayList<Cards> justWrong = new ArrayList<Cards>();
	
	//building the sample set of flashcards, this method probably won't exist (as is) 
	//in the final version of the project
	//(this is from the final version- it exists but doesn't do anything- i.e. it's not accessable by the program)
	public static void createDeck()
	{
	flashDeck.add(new Cards("Cat", "A furry animal"));
	flashDeck.add(new Cards("Apple", "A round, red fruit"));
	flashDeck.add(new Cards("Chair", "What you sit in"));
	flashDeck.add(new Cards("Eyes", "What you see out of"));
	}
	
	public static String returnALTerm(int inp)
	{
		return flashDeckHolder.get(inp).returnTerm();
	}
	
	public static String returnALDeff(int inp)
	{
		return flashDeckHolder.get(inp).returnDefinition();
	}
	
	public static void setRight(int j)
	{
		flashDeckHolder.get(j).setRight();
	}
	
	public static int returnLength()
	{
		return flashDeckHolder.size();
	}
	
	public static int returnWrongLength()
	{
		return justWrong.size();
	}
	
	//goes through flashDeckHolder and chooses only the flash cards that were previously incorrect, and adds them to justWrong
	//It then uses the randomizeArrayList method so that these go into the flashDeckHolder arrayList that is actually used
	public static void getJustWrong()
	{
		justWrong.clear();
		for (int i = 0; i<flashDeckHolder.size(); i++ )
		{
			if(flashDeckHolder.get(i).returnRight() == false)
			{
				justWrong.add(flashDeckHolder.get(i));
				for (int j = 0; j<justWrong.size(); j++ )
					System.out.println(justWrong.get(j).returnDefinition());
			}
			
		}
		randomizeArraylist(justWrong);
	}
	
	//Hypothetically should randomize the arraylist 
	//This is the method that has given me so much trouble
	//my main problem was that I had only cleared the final array list, not each individual array list
	//so it was basically re-adding the terms from the previous rounds
	// now that's been fixed and it works 
	
	//the method takes the instance variable flash cards and puts them in a holder array list
	//it chooses random ones from that arrayList (using the method I had come up with in class a few months ago)
	//and then adds it to another holder array list
	//finally, it adds the contents of that holder array list to the arrayList that is actually used
	public static void randomizeArraylist( ArrayList<Cards> aDeck )
	{
		int p = 0;
		flashDeckHolder2.clear();
		while ( p< aDeck.size())
		{
			flashDeckHolder2.add(aDeck.get(p));
			p++;
		}
	
		p = 0;
		randomizedFlashDeck.clear();
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
}
