import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    String [] questions = {
            "When was AutZone founded?",
            "In Tennessee, It's Illegal To Drive If You Are What?",
            "What's The Main Ingredient In Bombay Duck?",
            "In Florida, It's Illegal For Unmarried Women To Do What On Sundays?",
            "What Is Scotland's National Animal?",
            " A Group Of Ravens Is Known As?",
            "In Public Places In Florida, What's Illegal To Do If You Are Wearing A Swimsuit?",
            "In Ancient Greece, Throwing An Apple At Someone Was A Declaration Of What?",
            "In The U.S.A., Every 12 Seconds Someone Does What In A Holiday Inn?",
            "What Is The Color Of Aircraft Black Boxes?"

    };
    String[][] options = {
            {"1945","2010","1979","1890"},
            {"Under 18","Under an influence","Divorced","Asleep"},
            {"Fish","Duck","Chicken","Bombay"},
            {"Drink","Skydive","Attend Church","Go out"},
            {"A Dragon","The Lochness Monster","A Unicorn","Puppies"},
            {"Unkindness","Ravens","Ravians","A Flock"},
            {"Dance","Eat","Talk","Sing"},
            {"Love","Hate","Friendship","War"},
            {"Steals a Towel","Parties","Sleeps","Checks In"},
            {"Black","Orange","White","Clear"}
    };

    char[] answers = {
            'C',
            'D',
            'A',
            'B',
            'C',
            'A',
            'D',
            'A',
            'A',
            'B',
    };
    char guess;
    char answer;
    int index;
    int correctGuesses;
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





    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50) );
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("AWESOME");


        frame.add(textField);
        frame.setVisible(true);

    }
    public void nextQuestion() {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void displayAnswer(){

    }
    public void results(){

    }
}