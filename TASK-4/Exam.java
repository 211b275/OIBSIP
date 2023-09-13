import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
class Exam extends JFrame implements ActionListener 
{
    JLabel jLabel1, jLabel2;
    JRadioButton[] jb = new JRadioButton[6];
    JButton jB1, jB2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer;
    Exam(String s) 
    {
        super(s);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        add(jLabel1);
        add(jLabel2);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) 
        {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        jB1 = new JButton("Save and Next");
        jB2 = new JButton("After");
        jB1.addActionListener(this);
        jB2.addActionListener(this);
        add(jB1);
        add(jB2);
        set();
        jLabel1.setBounds(30, 40, 450, 20);
        jLabel2.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        jB1.setBounds(95, 240, 140, 30);
        jB2.setBounds(270, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

        final int[] timeLeft = {300}; 

        TimerTask task = new TimerTask() 
        {
            public void run() 
            {
                timeLeft[0]--;
                if (timeLeft[0] >= 0) 
                {
                    jLabel2.setText("Time left: " + timeLeft[0] + " sec.");
                } 
                else 
                {
                    timer.cancel();
                    jLabel2.setText("Time Out");
                }
            }
        };

        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == jB1) 
        {
            if (check()) 
            {
                count++;
            }
            current++;
            set();
            if (current == 9) 
            {
                jB1.setEnabled(false);
                jB2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Save for later")) 
        {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) 
            {
                jB2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) 
        {

            if (e.getActionCommand().equals("Review" + y)) 
            {
                if (check()) 
                {
                    count++;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }

            if(e.getActionCommand().equals("Result"))
            {
                if(check())
                    count += 1;
                current++;
                JOptionPane.showMessageDialog(this,"Score = "+count);
                System.exit(0);
            }
        }

    }

    String[] questions = 
    {
            "Who is the Father of Java programming language?",
            "Which of the following is not a valid access modifier in Java?",
            "Which of the following is not a primitive data type in Java?",
            "Which of the following is not a valid Java identifier?",
            "Exception created by try block is caught in which block?",
            "Which keyword is used to prevent a variable from being modified in Java?",
            "Identify the infinite loop?",
            "When is the finalize() method called?",
            "What is the implicit return type of constructor?",
            "Which keyword is used to declare an interface in java?"
    };
    String[][] choices = 
    {
            { "M.P.Java","charles Babbage", "James Gosling", "Pascal"},
            {"public", "protected", "private", "package-private"},
            {"int", "float", "string", "boolean"},
            {"myVariable", "my_variable", "_myVariable", "2myVariable"},
            {"catch", "throw", "final", "thrown"},
            {"const", "final", "static", "volatile"},
            {"for(;;)", "for()i=0;j<1;i--", "for(int=0;i++)", "All of the above"},
            {"Before garbage collection", "Before an object goes out of scope", "Before a variable goes out of scope", "None"},
            {"No return type", "A class object in which it is defined", "void", "None"},
            {"class", "interface", "implements", "abstract"}
    };
    int[] answers = {2, 3, 2, 3, 0, 1, 1, 0, 1, 1};

    void set() 
    {
        jb[4].setSelected(true);
        jLabel1.setText(questions[current]);
        for (int i = 0; i < 4; i++) 
        {
            jb[i].setText(choices[current][i]);
        }
        jLabel1.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) 
        {
            jb[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    boolean check() 
    {
        return jb[answers[current]].isSelected();
    }

}
