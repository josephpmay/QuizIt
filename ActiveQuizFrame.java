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
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActiveQuizFrame extends JFrame
{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT =400;
	
	private JLabel promtLabel;
	private JTextField imputField;
	private JButton submit;
	private JLabel correctOrNot;
	private JPanel panel;
	private JButton nextWord;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	//private JLabel correctAnswerIs;
	private QuizRunner quiz;
	private int rightCounter = 0;
	private int wrongCounter = 0;
	private JLabel displayRight;
	private JLabel displayWrong;
	private JLabel picLabel; //header image
	private int termNumber = 0;
	private int wrongTwice = 0;
	
	
	//constructor 
	public ActiveQuizFrame()
	{
		correctOrNot = new JLabel("");
		quiz = new QuizRunner();
		
		createTextField();
		createSubButton();
		createNextButton();
		createRightWrong();
		createHeader();
		createPanel();
		
		
		
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	//puts "quizIt" image as the header
	private void createHeader()
	{
		//Graphics2D g2 = (Graphics2D) g;
		
		//gets header image
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("/Users/joseph.may/Documents/workspace/Computer Science Data Structures Project/src/quizIt/1.png"));
		} catch (IOException e) {
			System.out.println("failed");
		}
		
		picLabel = new JLabel(new ImageIcon( img));
		
	}
	//creates the submit answer button
	private void createSubButton()
	{
		submit = new JButton ("Submit Answer");
		class AddTextListener implements ActionListener
		{
			boolean notFirst = false;
			//when the submit answer button is pressed
			//first conditional- checks if it is the right answer
				//if satisfies that, displays "correct", makes the submit button invisible
			    //if it is the flash card was not previously gotten incorrect in the current round
				//the card's right/wrong boolean is set as right and the number right displayed is increased
				//increases term number so it will later go on to the next word
			   
			public void actionPerformed(ActionEvent event)
			{
				
				//notFirst should prevent the program from setting the boolean in the array list to true 
				//if the user didn't get it right the first time
				String answer = imputField.getText();
				if (answer.equals(quiz.returnALTerm(termNumber)))
				{
					wrongTwice =0;
					correctOrNot.setText("Correct!");
					submit.setVisible(false);
					panel2.setVisible(true);
					if (notFirst == false)
					{
						quiz.setRight(termNumber);
						rightCounter++;
						displayRight.setText("Number Correct: " + Integer.toString(rightCounter));
						
					}
						
					termNumber++;
					//if the number write and wrong is the length of the flashcard deck, it is assumed that the the round
					//is finished and if none were incorrect, it gives the Joption of either restarting or exiting
					//if some were incorrect, makes the deck contain just the cards that were incorrect and restarts all values
					//so that the next round can begin
					if ((rightCounter + wrongCounter) == quiz.returnLength())
					{
						int kmn = 0;
						if (wrongCounter == 0)
						{
							kmn = JOptionPane.showConfirmDialog( null,"You have gotten every \n card in this deck correct \n would you like to go through \n these flashcards again?","Success",JOptionPane.YES_NO_OPTION);
							if (kmn == 0)
							{
								UI.close2();
								CardBank.setAllWrong();
								UI.newRound();
							}
							else
								System.exit(0);
						}
						else
						{
						quiz.getJustWrong();
						rightCounter =0;
						wrongCounter =0;
						displayWrong.setText("Number Incorrect: " + Integer.toString(wrongCounter));
						displayRight.setText("Number Correct: " + Integer.toString(rightCounter));
						termNumber = 0;
						correctOrNot.setText("Correct. Click 'Continue' to go on to the next round");
						}
					}
					
					notFirst = false;
					
				}
				
			//if the term is wrong, displays the correct answer (which must be typed to continue on
				//and sets notFirst = true, so that when the correct term is put in, it doesn't set it to right
				//it also only increases the wrong counter if the wrong word was typed in twice
				
				else
				{
					correctOrNot.setText("Incorrect! The correct answer is:" + quiz.returnALTerm(termNumber));
					notFirst = true;
					if (wrongTwice ==0)
						wrongCounter++;
					wrongTwice++;
					displayWrong.setText("Number Incorrect: " + Integer.toString(wrongCounter));

				}
			}

		}
		ActionListener listener = new AddTextListener();
		submit.addActionListener(listener); 
	}
	// this is the continue button- pretty self explanatory
	public void createNextButton()
	{
		nextWord = new JButton("Continue");
		class ActionMoveOn implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
			promtLabel.setText(quiz.returnALDeff(termNumber));
			imputField.setText("");
			panel2.setVisible(false);
			correctOrNot.setText("");
			submit.setVisible(true);
			}
		}
		ActionListener listener = new ActionMoveOn();
		nextWord.addActionListener(listener);
	}
	
	public void createRightWrong()
	{
		displayRight = new JLabel("Number Correct: " + Integer.toString(rightCounter));
		displayWrong = new JLabel("Number Incorrect: " + Integer.toString(wrongCounter));
	}
	
	private void createTextField()
	{
		promtLabel = new JLabel(quiz.returnALDeff(termNumber));
		
		final int FIELD_WIDTH = 15;
		imputField = new JTextField(FIELD_WIDTH);
		imputField.setText("");
		
	}
	// builds the frame GUI for the ActiveQuizFrame 
	//builds a number of panels, adds elements in the panels (and determines the layout of those elements)
	//and then ads the panels into the frame 
	private void createPanel()
	{
	panel = new JPanel();
	
	panel.add(promtLabel);
	panel.add(imputField);
	panel.add(submit);
	panel.add(correctOrNot);
	
	
	
	panel2 = new JPanel();
	panel2.add(nextWord);
	panel2.setVisible(false);
	
	panel3 = new JPanel();
	panel3.add(picLabel);

	
	panel4 = new JPanel(new BorderLayout());
	panel4.add(displayRight, BorderLayout.NORTH);
	panel4.add(displayWrong, BorderLayout.CENTER);
	
	setLayout(new BorderLayout());
	add(panel3, BorderLayout.NORTH);
	add(panel, BorderLayout.CENTER);
	add(panel2, BorderLayout.SOUTH);
	add(panel4, BorderLayout.WEST);
	}
}

