package com.mypackage;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;
class Main extends JFrame
{
    JTextField guess_work, bestscore, total;
    ButtonListener b1;
    ButtonListener2 b2;
    ButtonListener3 b3;
    JLabel input,guess,trail,Best,total_require,imglabel;

    int rand=(int) (Math.random()*100);
    int count=0;
    public Main()
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        guess = new JLabel("Guess the Number ?");
        guess.setForeground(Color.RED);
        guess.setFont(new Font("times new roman",Font.BOLD,24));
        guess.setSize(270,20);
        guess.setLocation(70,70);

        input=new JLabel("Enter a number between 1-101");
        input.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        input.setSize(270,20);
        input.setLocation(70,90);

        trail = new JLabel("Try and guess it !");
        trail.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        trail.setSize(270,20);
        trail.setLocation(110,160);

        guess_work = new JTextField(20);
        guess_work.setSize(50,30);
        guess_work.setLocation(140,120);

        bestscore = new JTextField(10);
        bestscore.setSize(30,20);
        bestscore.setLocation(10,10);

        Best = new JLabel("Best Score");
        Best.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        Best.setSize(250,20);
        Best.setLocation(50,10);

        total = new JTextField(10);
        total.setSize(30,20);
        total.setLocation(10,40);

        total_require = new JLabel("Number of Guesses");
        total_require .setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        total_require.setSize(270,20);
        total_require.setLocation(50,40);


        JButton guessbutton =new JButton("Guess");
        guessbutton.setSize(100,30);
        guessbutton.setLocation(110,190);
        guessbutton.setBackground(Color.LIGHT_GRAY);
        b1 = new ButtonListener();
        guessbutton.addActionListener(b1);

        JButton giveupbutton = new JButton("Give up!");
        giveupbutton.setSize(100,30);
        giveupbutton.setLocation(50,240);
        giveupbutton.setBackground(Color.LIGHT_GRAY);
        b2 = new ButtonListener2();
        giveupbutton.addActionListener(b2);

        JButton playagainbutton = new JButton("Again!");
        playagainbutton.setSize(100,30);
        playagainbutton.setLocation(170,240);
        playagainbutton.setBackground(Color.LIGHT_GRAY);
        b3 = new ButtonListener3();
        playagainbutton.addActionListener(b3);

        c.add(Best);
        c.add(total_require);
        c.add(trail);
        c.add(guess);
        c.add(input);
        c.add(guess);
        c.add(bestscore);
        c.add(guess_work);
        c.add(guessbutton);
        c.add(giveupbutton);
        c.add(playagainbutton);

        bestscore.setEditable(false);
        guess_work.setEditable(false);
        setTitle("GUESS: ");
        setSize(500,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(guess_work.getText());
            count=count+1;
            if(a<rand)
            {
                trail.setText(a+" kam hai, dobara prayas!!");
            }
            else if(a>rand)
            {
            	setDefaultCloseOperation(EXIT_ON_CLOSE);;
            }
            else
            {
                trail.setText("You win!!");
                if(count<bestScore)
                {
                    bestScore=count;
                    bestscore.setText(bestScore+"");
                }
                else 
                {
                    bestscore.setText("" + bestScore);
                }
                guess_work.setEditable(false);
            }

            guess_work.requestFocus();
            guess_work.selectAll();
            total.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            total.setText("");
            trail.setText("The correct answer is "+rand+"!!");
            guess_work.setText("");
            guess_work.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            guess.setText("");
            total.setText("");
            trail.setText("Try and guess it !");
            total.setText("");
            count=0;
            guess_work.setEditable(true);
            guess_work.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}