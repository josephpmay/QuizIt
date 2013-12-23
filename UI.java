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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

import javax.imageio.ImageIO;

public class UI {
	
	static JFrame setFrame;
	static JFrame quizFrame;
	
	
	//I moved a lot of this class into the individual frame classes
	//still, it ends up being useful to be able to call each frame 
	public static void main (String[] args)
	{
	
	//constructs JFrame
//	JFrame frame = new JFrame();
//	frame.setSize(600, 400);
//	frame.setTitle("QuizIt");
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//constructs JPanel
//	JPanel content = new JPanel();
	
	
	//constructs Header
//	DisplayHeader header = new DisplayHeader();
//	header.setPreferredSize(new Dimension(600,300));
	//adds elements to content JPanel
//	content.add(header);
	
	
	//creates input box
	final int width = 15;
	final JTextField inputField = new JTextField(width);
	
	//adds content JPanel into the main JFrame
	//frame.add(content);
	
	

	
	
	setFrame = new CreateSetFrame();
	setFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setFrame.setVisible(true);
	
	//frame.setVisible(true); 
	}
	
	
/*	public static class DisplayHeader extends JComponent
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			//gets header image
			//not currently working
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("/Users/joseph.may/Documents/workspace/Computer Science Data Structures Project/src/quizIt/1.png"));
			} catch (IOException e) {
				System.out.println("failed");
			}
			
			
		//	Rectangle box = new Rectangle(5, 10, 150, 50);
			
		//	g2.drawImage(img, 30, 30, null);
		//	g2.fill(box);
			
		}  */
	//}
	
	//closes creatSetFrame and opens ActiveQuizFrame
	public static void close()
	{
		setFrame.dispose();
		 quizFrame = new ActiveQuizFrame();
		quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizFrame.setVisible(true);
	}
	
	//closes ActiveQuizFrame 
	public static void close2()
	{
		quizFrame.dispose();
	}
	
	//creates a new Active Quiz Frame
	public static void newRound()
	{
		quizFrame = new ActiveQuizFrame();
		quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizFrame.setVisible(true);
	}
}
