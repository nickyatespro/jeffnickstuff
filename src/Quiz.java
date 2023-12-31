import org.omg.CORBA.PolicyErrorCodeHelper;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Quiz implements ActionListener {

    String [] questions = {
            "What year was AutoZone founded?",
            "What was the name of the company BEFORE it was changed to AutoZone?",
            "What is AutoZone's primary color?",
            "What extreme sport is Jeff involved in?",
            "What instrument does Nick play?",
            "What is Jeff's middle name?",
            "What is Nick's middle name?",

    };
    String[][] options = {
            {"1945","2010","1979","1890"},
            {"AutoPlanet", "AutoWorld", "AutoStop", "AutoShack"},
            {"Red", "Purple", "Yellow", "Blue"},
            {"Skateboarding", "Motocross", "BMX", "Surfing"},
            {"Bass", "Guitar", "Both A and B", "Neither A or B"},
            {"Eugene", "Bryant", "Orwell", "Grant"},
            {"Tomlin", "David", "Taylor", "Winston"},

    };

    char[] answers = {
            'C',
            'D',
            'A',
            'B',
            'C',
            'D',
            'C',

    };
    char guess;
    char answer;
    int index;
    int correctGuesses = 0;
    int totalQuestions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();

    Timer countdown = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds --;
            secondsLeft.setText(String.valueOf(seconds));
            if(seconds <=0) {
                displayAnswer();
            }
        }
    });





    public Quiz(){
        frame.add(textArea);
        frame.add(textField);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(secondsLeft);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50) );
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("monospace",Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Jeff & Nick's Quiz");

        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setLineWrap(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25, 250,0));
        textArea.setFont(new Font("monospace", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("monospace", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("monospace", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("monospace", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("monospace", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(125,100,500, 100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("monospace", Font.PLAIN, 35));
        answerLabelA.setText("Test Label A");

        answerLabelB.setBounds(125,200,500, 100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("monospace", Font.PLAIN, 35));
        answerLabelB.setText("Test Label B");

        answerLabelC.setBounds(125,300,500, 100);
        answerLabelC.setBackground(new Color(50,50,50));
        answerLabelC.setForeground(new Color(25,255,0));
        answerLabelC.setFont(new Font("monospace", Font.PLAIN, 35));
        answerLabelC.setText("Test Label C");

        answerLabelD.setBounds(125,400,500, 100);
        answerLabelD.setBackground(new Color(50,50,50));
        answerLabelD.setForeground(new Color(25,255,0));
        answerLabelD.setFont(new Font("monospace", Font.PLAIN, 35));
        answerLabelD.setText("Test Label D");

        secondsLeft.setBounds(535,510,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("monospace", Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        numberRight.setBounds(225,225,200,100);
        numberRight.setBackground(new Color(25,25,25));
        numberRight.setForeground(new Color(25,255,0));
        numberRight.setFont(new Font("monospace",Font.BOLD, 50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("monospace", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();

    }
    public void nextQuestion() {
        if(index >= totalQuestions) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            countdown.start();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA) {
            answer = 'A';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource()==buttonB) {
            answer = 'B';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource()==buttonC) {
            answer = 'C';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource()==buttonD) {
            answer = 'D';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        displayAnswer();

    }
    public void displayAnswer(){

        countdown.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            answerLabelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answerLabelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answerLabelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answerLabelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(25,255,0));
                answerLabelB.setForeground(new Color(25,255,0));
                answerLabelC.setForeground(new Color(25,255,0));
                answerLabelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();

            }
        });
        pause.setRepeats(false);
        pause.start();


    }
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correctGuesses / (double) totalQuestions) * 100);

        textField.setText("Results");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

        numberRight.setText("(" + correctGuesses + "/" + totalQuestions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(numberRight);

    }
}