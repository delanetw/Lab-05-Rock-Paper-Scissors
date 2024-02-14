import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    //ActionListener
    ActionListener paperSelection = new PaperListener();
    ActionListener quit = new QuitListener();
    ActionListener rockSelection = new RockListener();
    ActionListener scissorsSelection = new ScissorsListener();

    //Buttons
    JButton paperBtn;
    JButton quitBtn;
    JButton rockBtn;
    JButton scissorBtn;
    JButton spaceBtn;
    JButton spaceBtn2;

    //Label
    JLabel title;

    //Panel
    JPanel controlPnl;
    JPanel displayPnl;
    JPanel main;
    JPanel scorePnl;
    JPanel topPnl;

    //ScrollPane
    JScrollPane scroll;

    //TextArea
    JTextArea gameResults;

    //TextField
    JTextField computerWinsTF;
    JTextField playerWinsTF;
    JTextField tiesTF;

    //ImageIcon
    ImageIcon paperIcon;
    ImageIcon rockIcon;
    ImageIcon scissorIcon;

    //Int
    int computerWinsNum;
    int playerWinsNum;
    int screenHeight;
    int screenWidth;
    int tiesNum;

    //Random
    Random rnd = new Random();

    //String
    String playerWinsStr;
    String computerWinsStr;
    String tiesStr;

    public RockPaperScissorsFrame()
    {
        setTitle("Rock Paper Scissors Game");
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(102, 35, 80));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        RPSLabel();
        main.add(topPnl, BorderLayout.NORTH);

        RPSDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
    }

        private void RPSLabel()
        {
            topPnl = new JPanel();
            topPnl.setBackground(new Color(33, 33, 33));
            title = new JLabel("Welcome to Rock Paper Scissors");
            title.setFont(new Font("Dialog", Font.BOLD, 48));
            title.setForeground(new Color(204, 70, 160));
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setVerticalAlignment(JLabel.CENTER);
            title.setHorizontalTextPosition(JLabel.CENTER);
            title.setVerticalTextPosition(JLabel.BOTTOM);
            topPnl.add(title);
        }

        private void RPSDisplay()
        {
            displayPnl = new JPanel();
            displayPnl.setBackground(new Color(33, 33, 33));
            gameResults = new JTextArea(20, 70);

            gameResults.setFont(new Font("SansSerif", Font.ITALIC, 12));
            scroll = new JScrollPane(gameResults);
            playerWinsTF = new JTextField("Player Wins: " + playerWinsNum);
            playerWinsTF.setEditable(false);
            computerWinsTF = new JTextField("Computer Wins: " + computerWinsNum);
            computerWinsTF.setEditable(false);
            tiesTF = new JTextField("Ties: " + tiesNum);
            tiesTF.setEditable(false);

            displayPnl.add(scroll);
        }

        private void ControlPanel()
        {
            controlPnl = new JPanel();
            controlPnl.setBackground(new Color(33, 33, 33));
            controlPnl.setLayout(new GridLayout(3, 3));

            controlPnl.add(playerWinsTF);
            playerWinsTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            controlPnl.add(computerWinsTF);
            computerWinsTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            controlPnl.add(tiesTF);
            tiesTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));

            rockIcon = new ImageIcon("src/Rock.png");
            paperIcon = new ImageIcon("src/Paper.png");
            scissorIcon = new ImageIcon("src/Scissors.png");

            Image rockImage = rockIcon.getImage();
            Image rocknewIMG = rockImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
            rockIcon = new ImageIcon((rocknewIMG));

            Image paperImage = paperIcon.getImage();
            Image papernewIMG = paperImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
            paperIcon = new ImageIcon((papernewIMG));

            Image scissorImage = scissorIcon.getImage();
            Image scissornewIMG = scissorImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
            scissorIcon = new ImageIcon((scissornewIMG));

            rockBtn = new JButton("Rock", rockIcon);
            rockBtn.addActionListener(rockSelection);
            rockBtn.setFont(new Font("Dialog", Font.BOLD, 14));

            paperBtn = new JButton("Paper", paperIcon);
            paperBtn.addActionListener(paperSelection);
            paperBtn.setFont(new Font("Dialog", Font.BOLD, 14));

            scissorBtn = new JButton("Scissors", scissorIcon);
            scissorBtn.addActionListener(scissorsSelection);
            scissorBtn.setFont(new Font("Dialog", Font.BOLD, 14));

            spaceBtn = new JButton("_");
            spaceBtn.setBackground(new Color(33, 33, 33));
            spaceBtn.setOpaque(true);
            spaceBtn.setFont(new Font("Dialog", Font.BOLD, 14));

            quitBtn = new JButton("Quit");
            quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
            quitBtn.setFont(new Font("Dialog", Font.BOLD, 14));

            spaceBtn2 = new JButton("_");
            spaceBtn2.setBackground(new Color(33, 33, 33));
            spaceBtn2.setFont(new Font("Dialog", Font.BOLD, 14));

            controlPnl.add(rockBtn);
            controlPnl.add(paperBtn);
            controlPnl.add(scissorBtn);
            controlPnl.add(spaceBtn);
            controlPnl.add(quitBtn);
            controlPnl.add(spaceBtn2);
        }


    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }

    private class RockListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked rock, the computer picked rock. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
            else if (compMove == 1)//paper
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked rock, the computer picked paper. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
            else if (compMove == 2)//scissors
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked rock, the computer picked scissors. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
        }
    }


    private class PaperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked paper, the computer picked rock. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
            else if (compMove == 1)//paper
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked paper, the computer picked paper. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
            else if (compMove == 2)//scissors
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked paper, the computer picked scissors. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
        }
    }


    private class ScissorsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked scissors, the computer picked rock. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
            else if (compMove == 1)//paper
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked scissors, the computer picked paper. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
            else if (compMove == 2)//scissors
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked scissors, the computer picked scissors. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
        }
    }
}