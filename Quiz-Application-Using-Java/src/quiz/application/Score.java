package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Requirements met: GUI Design, Data Handling (via QuestionManager),
 * and User Interaction (Play Again button).
 */
public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image handling
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
            Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 200, 300, 250);
            add(image);
        } catch (Exception e) {
            System.out.println("Score image not found.");
        }
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        // TRIGGERING FILE HANDLING
        QuestionManager qm = new QuestionManager();
        qm.saveScore(name, score);

        JLabel status = new JLabel("Note: Your score has been saved to scores.txt");
        status.setBounds(350, 240, 400, 20);
        status.setFont(new Font("Tahoma", Font.ITALIC, 12));
        status.setForeground(new Color(30, 144, 254));
        add(status);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 300, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login(); // Loop back to start
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}