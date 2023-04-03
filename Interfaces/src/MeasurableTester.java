import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
/**
   This program demonstrates the measurable Country class.
*/
public class MeasurableTester { 

   public static void main(String[] args) {
	  //Countries
	  System.out.println("Countries Data");
	  Measurable[] countries = new Measurable[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 513120);
      countries[2] = new Country("Belgium", 30510);
      double avg=Data.average(countries);
      System.out.println("Average area: " + avg);
      System.out.println("Expected: 239950");
      System.out.println("");
      double maxData = Data.max(countries);
      System.out.println("Maximum area: " + maxData);
      System.out.println("Expected: 513120");
      System.out.println("");
     
      //Bank Accounts
      System.out.println("Bank Account Data");
      Measurable[] bank = new Measurable[3];
      bank[0] = new BankAccount(176220);
      bank[1] = new BankAccount(513120);
      bank[2] = new BankAccount(30510);
      avg=Data.average(bank);
      System.out.println("Average balance: " + avg);
      System.out.println("Expected: 239950");
      System.out.println("");
      maxData = Data.max(bank);
      System.out.println("Maximum balance: " + maxData);
      System.out.println("Expected: 513120");
      System.out.println("");
      
      //Quiz Scores
      System.out.println("Quiz Score Data");
      Measurable[] quiz = new Measurable[5];
      quiz[0] = new Quiz(95);
      quiz[1] = new Quiz(80);
      quiz[2] = new Quiz(90);
      quiz[3] = new Quiz(50);
      quiz[4] = new Quiz(75);
      avg = Data.average(quiz);
      System.out.println("Average score: " + avg);
      System.out.println("Expected: 78");
      System.out.println("");
      maxData = Data.max(quiz);
      System.out.println("Maximum score: " + maxData);
      System.out.println("Expected: 95");
      System.out.println("");
      
      //Buttons
      Scanner scnr = new Scanner(System.in);
	    System.out.print("Enter metric to use, 1 for maximum, 2 for minimum, 3 for average: ");
	      int metric = scnr.nextInt();
	      if(metric == 1) { //Maximum
	    	  JFrame frame = new JFrame();
	    	  JPanel panel = new JPanel();
	    	  JButton max1 = new JButton("Get Maximum Balance");
	    	  JButton max2 = new JButton("Get Maximum Area");
	    	  JButton max3 = new JButton("Get Maximum Score");
	    	  
	    	  panel.add(max1); //BankAccount
	    	  panel.add(max2); //Country
	    	  panel.add(max3); //Quiz
	    	  
	    	  frame.add(panel);
	    	  
	    	  ActionListener listenerMaxBank = new MeasurableListener(bank, 3, 1, 1);
	          max1.addActionListener(listenerMaxBank);
	          ActionListener listenerMaxCountry = new MeasurableListener(countries, 3, 1, 2);
	          max2.addActionListener(listenerMaxCountry);
	          ActionListener listenerMaxQuiz = new MeasurableListener(quiz, 5, 1, 3);
	          max3.addActionListener(listenerMaxQuiz);
	          
	          frame.setSize(250, 150);
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.setVisible(true);
	      }
	      else if(metric == 2) { //Minimum
	    	  JFrame frame = new JFrame();
	    	  JPanel panel = new JPanel();
	    	  JButton min1 = new JButton("Get Minimum Balance");
	    	  JButton min2 = new JButton("Get Minimum Area");
	    	  JButton min3 = new JButton("Get Minimum Score");
	    	  
	    	  panel.add(min1); //BankAccount
	    	  panel.add(min2); //Country
	    	  panel.add(min3); //Quiz
	    	  
	    	  frame.add(panel);
	    	  
	    	  ActionListener listenerMinBank = new MeasurableListener(bank, 3, 2, 1);
	          min1.addActionListener(listenerMinBank);
	          ActionListener listenerMinCountry = new MeasurableListener(countries, 3, 2, 2);
	          min2.addActionListener(listenerMinCountry);
	          ActionListener listenerMinQuiz = new MeasurableListener(quiz, 5, 2, 3);
	          min3.addActionListener(listenerMinQuiz);
	          
	          frame.setSize(250, 150);
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.setVisible(true);
	      }
	      else { //Average
	    	  JFrame frame = new JFrame();
	    	  JPanel panel = new JPanel();
	    	  JButton avg1 = new JButton("Get Average Balance");
	    	  JButton avg2 = new JButton("Get Average Area");
	    	  JButton avg3 = new JButton("Get Average Score");
	    	  
	    	  panel.add(avg1); //BankAccount
	    	  panel.add(avg2); //Country
	    	  panel.add(avg3); //Quiz
	    	  
	    	  frame.add(panel);
	    	  
	    	  ActionListener listenerAvgBank = new MeasurableListener(bank, 3, 3, 1);
	    	  avg1.addActionListener(listenerAvgBank);
	          ActionListener listenerAvgCountry = new MeasurableListener(countries, 3, 3, 2);
	          avg2.addActionListener(listenerAvgCountry);
	          ActionListener listenerAvgQuiz = new MeasurableListener(quiz, 5, 3, 3);
	          avg3.addActionListener(listenerAvgQuiz);
	          
	          frame.setSize(250, 150);
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.setVisible(true);
	      }
      
   }
   
}
