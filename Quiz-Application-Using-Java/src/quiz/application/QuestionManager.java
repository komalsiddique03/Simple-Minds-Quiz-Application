package quiz.application;

import java.io.*;

/**
 * Requirements met: 
 * 1. Abstraction (abstract class QuizData)
 * 2. File Handling (Writing to scores.txt)
 * 3. Error Handling (Try-with-resources)
 */

// Abstract class to demonstrate Abstraction & Polymorphism
abstract class QuizData {
    public abstract void saveScore(String name, int score);
}

public class QuestionManager extends QuizData {

    // Implementation of File Handling (MANDATORY REQUIREMENT)
    @Override
    public void saveScore(String name, int score) {
        // This will create a file named "scores.txt" in your project folder
        // The 'true' parameter in FileWriter allows appending data so scores aren't deleted
        try (FileWriter fw = new FileWriter("scores.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println("User: " + name + " | Score: " + score + " | Date: " + new java.util.Date());
            System.out.println("Score successfully saved to file.");
            
        } catch (IOException e) {
            // Proper handling of runtime errors with user-friendly messages
            System.err.println("Error saving score to file: " + e.getMessage());
        }
    }
}