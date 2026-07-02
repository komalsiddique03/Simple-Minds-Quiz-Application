package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Requirement met: User Interaction, Inheritance (extends JFrame),
 * and proper class-to-class communication.
 */
public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Dynamic Welcome Heading
        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        // Displaying Rules using HTML formatting for easy line breaks
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "</html>"
        );
        add(rules);
        
        // Back Button to return to Login
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        // Start Button to proceed to the Quiz
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        // Window Configuration
        setSize(800, 650);
        setLocation(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name); // Proceeding to Class 3
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login(); // Returning to Class 1
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}