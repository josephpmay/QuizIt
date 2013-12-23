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

//this class is mostly unnecessary for the current program, however I wrote it so that 
//the program could be expanded in the future if I wanted to create a save functionality
//basically, it creates an arrayList of arrayLists that store every flashcard deck that has 
//been created. It is basically curently configured to only deal with the first ArrayList in deckHolder

public class CardBank {
	private static ArrayList<ArrayList> deckHolder = new ArrayList<ArrayList>();
	static int i = -1;
	
	public static void addArray()
	{
		deckHolder.add(new ArrayList<Cards>());
		i++;
	}
	
	public static void addTerm(Cards x)
	{
		deckHolder.get(i).add(x);
	}
	
	//this is important for starting a new game with an existing set, because if some are right, they will 
	//not be asked even if they weren't gotten right
	public static void setAllWrong()
	{
		for(Object n: deckHolder.get(i))
			((Cards) n).setWrong();
		
	}
	
	public static ArrayList returnLatest()
	{
		return deckHolder.get(i);
	}
	
	public static int returnLastIndex()
	{
		return i;
	}
	
}
