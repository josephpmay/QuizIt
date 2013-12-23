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

public class Cards {

	private String setName;
	private String term;
	private String definition;
	private boolean isRight = false;
	
	public Cards(String term1, String definition1)
	{
		term = term1;
		definition = definition1;
	}
	
	public Cards(String name, String term1, String definition1)
	{
		term = term1;
		definition = definition1;
		setName = name;
	}
	
	//name should be the same for all terms in a deck 
	public String getSetName()
	{
		return setName;
	}
	
	public void setSetName(String s)
	{
		setName = s; 
	}
	
	public String returnTerm()
	{
		return term;
	}
	
	public String returnName()
	{
		return setName;
	}
	
	public void setRight()
	{
		isRight = true;
	}
	
	public void setWrong()
	{
		isRight = false;
	}
	
	public boolean returnRight()
	{
		return isRight;
	}
	
	public String returnDefinition()
	{
		return definition;
	}
	
}
