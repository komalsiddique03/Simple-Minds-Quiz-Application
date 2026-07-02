package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Requirement met: GUI-Based Application, User Interaction, 
 * and Basic Validation (checking for empty name field).
 */
public class Login extends JFrame implements ActionListener {
    
    // Using instance variables for accessibility within the class
    private JButton rules, back;
    private JTextField tfname;
    
    public Login() {
        // Basic Frame Setup
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image handling with error check (standard for project quality)
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0, 0, 600, 500);
            add(image);
        } catch (Exception e) {
            System.out.println("Icon not found, continuing with text only.");
        }
        
        // Heading
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        // Name Label
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        
        // Name Input Field
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        // Rules Button
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        // Back Button
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        // Window settings
        setSize(1200, 500);
        setLocation(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures app closes fully
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText().trim();
            
            // MANDATORY REQUIREMENT: Basic Validation
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Name field cannot be empty!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                setVisible(false);
                new Rules(name); // Proceeding to Class 2
            }
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            System.exit(0); // Closes the application
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}