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
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

// this is the frame used to create flashcard sets 
//when the program is run, this is what pops up
public class CreateSetFrame extends JFrame
	{
		private static final int FRAME_WIDTH = 600;
		private static final int FRAME_HEIGHT =400;
		private JLabel picLabel;
		private JPanel panel; 
		private JPanel panel2;
		private JPanel panel3;
		private JPanel panel4;
		private JLabel setTitle;
		private JTextField titleField;
		private JLabel promptTerm;
		private JLabel promptDefinition;
		private JTextField termField;
		private JTextField definitionField;
		private JButton enterNext;
		private JButton complete;
		private  int i;
		private Component promptDefnintion;
		
		public CreateSetFrame()
		{
		i =1;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		CardBank.addArray();
		createHeader();
		createTittleField();
		createTDField();
		createNextButton();
		createCompleteButton();
		createPanel();
		}
		
		//puts the QuizIt logo as the header
		private void createHeader()
		{
			//gets header image
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("/Users/joseph.may/Documents/workspace/Computer Science Data Structures Project/src/quizIt/1.png"));
			} catch (IOException e) {
				System.out.println("failed");
			}
			
			picLabel = new JLabel(new ImageIcon( img));
			
		}
		
		
		private void createTittleField()
		{
			setTitle = new JLabel("Title (Required):");
			
			final int FIELD_WIDTH = 15;
			titleField = new JTextField(FIELD_WIDTH);
			titleField.setText("");
		}
		
		private void createTDField()
		{
			promptTerm = new JLabel("Term: ");
			promptDefinition = new JLabel("     Definition: ");
			
			final int FIELD_WIDTH = 12;
			termField = new JTextField(FIELD_WIDTH);
			termField.setText("");
			definitionField = new JTextField(FIELD_WIDTH);
			definitionField.setText("");
		}
		
		//creates takes what is currently typed in the term and definition blanks and creates a flashcard with it
		//adds the card to the current deck of cards (because of how the CardBank class is set up, will always automatically
		//add them to the right deck.
		private void createNextButton()
		{
			enterNext = new JButton("Next Term");
			class ActiongoOn implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					Cards card = new Cards(titleField.getText(), termField.getText(), definitionField.getText());
					CardBank.addTerm(card);
//					System.out.println(card.returnDefinition() + " " + card.returnTerm() + " " + card.returnName());
					termField.setText("");
					definitionField.setText("");
				}
			}
			ActionListener listener = new ActiongoOn();
			enterNext.addActionListener(listener);
			
		}
		
		//Does the same thing as the next button, excepts it closes the creation frame
		private void createCompleteButton()
		{
			complete = new JButton("Done");
			class ActionClose implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					Cards card = new Cards(titleField.getText(), termField.getText(), definitionField.getText());
					CardBank.addTerm(card);
					UI.close();
				}
			}
			ActionListener listen = new ActionClose();
			complete.addActionListener(listen);
		}
		
		private void createPanel()
		{
			panel = new JPanel(new BorderLayout());
			panel.add(picLabel, BorderLayout.NORTH);
			
			
			promptTerm = new JLabel("Term:");
			
			panel3 = new JPanel();
			panel3.add(setTitle);
			panel3.add(titleField);
			
			panel.add(panel3, BorderLayout.SOUTH);
			
			panel2 = new JPanel();
			panel2.add(promptTerm);
			panel2.add(termField);
			panel2.add(promptDefinition);
			panel2.add(definitionField);
			
			panel4 = new JPanel();
			panel4.add(enterNext);
			panel4.add(complete);
			
			setLayout(new BorderLayout());
			add(panel, BorderLayout.NORTH);
			
			add(panel2, BorderLayout.CENTER);
			add(panel4, BorderLayout.SOUTH);
		}
}
