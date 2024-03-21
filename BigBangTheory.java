import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class BigBangTheory {

	public static void main(String[] args) {

		/* Create method that provides user with rock, paper, scissors, lizard
		 * or spock depending what random number they receive
		 * 
		 * User will make a choice
		 * 
		 * Computers choice will be shown
		 */
		JFrame frame = new JFrame("Rock Paper Scissors Lizard Spock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton rockButton = new JButton("Rock");
		JButton paperButton = new JButton("Paper");
		JButton scissorsButton = new JButton("Scissors");
		JButton lizardButton = new JButton("Lizard");
		JButton spockButton = new JButton("Spock");
		
		panel.add(rockButton);
		panel.add(paperButton);
		panel.add(scissorsButton);
		panel.add(lizardButton);
		panel.add(spockButton);
		
		ActionListener actionListener = new ActionListener()
		{
					public void actionPerformed(ActionEvent e)
					{
						String userChoice = e.getActionCommand();
						String computerChoice = computerChoice();
						String result = decideWinner(userChoice, computerChoice);
						JOptionPane.showMessageDialog(frame, result);
					}
				
			
		};
		
		rockButton.addActionListener(actionListener);
		paperButton.addActionListener(actionListener);
		scissorsButton.addActionListener(actionListener);
		lizardButton.addActionListener(actionListener);
		spockButton.addActionListener(actionListener);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
		
	}

	public static String computerChoice()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(5)+1;
		
		String computerChoice = "";
		switch (randomNumber)
		{
		case 1:
			computerChoice = "Rock";
			break;
		case 2:
			computerChoice = "Paper";
			break;
		case 3:
			computerChoice = "Scissors";
			break;
		case 4:
			computerChoice = "Lizard";
			break;
		case 5:
			computerChoice = "Spock";
			break;
		}
		
		return computerChoice;
	}
	
	public static String decideWinner(String userChoice, String computerChoice)
	{
		String result = "You Lose!";
		String additionalWinningMessage = "";
		
		if (userChoice.equals(computerChoice))
		{
			return "Draw!";
		}
		//Create switch statements nested with if statements
		//Gather userChoices, and what other choices it beats
		switch (userChoice)
		{
		case "Rock":
			if (computerChoice.equals("Scissors") || computerChoice.equals("Lizard"))
			{
				result = "You win!";
				
				if (computerChoice.equals("Scissors"))
				{
					additionalWinningMessage = "Rock crushes Scissors!";
				}
				else
				{
					additionalWinningMessage = "Rock crushes Lizard!";
				}
				
			}
			break;
		case "Paper":
			if (computerChoice.equals("Rock") || computerChoice.equals("Spock"))
			{
				result = "You win!";
				
				if (computerChoice.equals("Rock"))
				{
					additionalWinningMessage = "Paper covers Rock!";
				}
				else
				{
					additionalWinningMessage = "Paper disproves Spock!";
				}
			}
			break;
		case "Scissors":
			if (computerChoice.equals("Paper") || computerChoice.equals("Lizard"))
			{
				result = "You win!";
				
				if (computerChoice.equals("Paper"))
				{
					additionalWinningMessage = "Scissors cuts Paper!";
				}
				else
				{
					additionalWinningMessage = "Scissors decapitates Lizard!";

				}
			}
			break;
		case "Lizard":
			if (computerChoice.equals("Spock") || computerChoice.equals("Paper"))
			{
				result = "You win!";
				
				if (computerChoice.equals("Spock"))
				{
					additionalWinningMessage = "Lizard poisons Spock!";
				}
				else
				{
					additionalWinningMessage = "Lizard eats Paper!";
				}
			}
			break;
		case "Spock":
			if (computerChoice.equals("Scissors") || computerChoice.equals("Rock"))
			{
				result = "You win!";
				if (computerChoice.equals("Scissors"))
				{
					additionalWinningMessage = "Spock smashes Scissors!";
				}
				else
				{
					additionalWinningMessage = "Spock vaporizes Rock!";

				}
			}
			break;
		}
		return result + " Computer chose: " + computerChoice + "! " + additionalWinningMessage;
}
}	
