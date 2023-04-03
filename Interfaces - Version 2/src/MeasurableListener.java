import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeasurableListener implements ActionListener {
	
	private int metrics; //Decides whether to output maximum, minimum, or average
	private int classes; //Decides whether to output BankAccount, Country, or Quiz
	private Measurable[] measures; 
	
	public MeasurableListener(Measurable[] objects, int index, int metrics, int classes) {
		measures = new Measurable[index];
		
		for(int i = 0; i < objects.length; i++) {
			measures[i] = objects[i];
		}
		
		this.metrics = metrics;
		this.classes = classes;
	}
	public void actionPerformed(ActionEvent event) {
		if(metrics == 1) { //Maximum
			if(classes == 1) { //BankAccount
				System.out.println("Maximum Account Balance is " + Data.max(measures));
			}
			if(classes == 2) { //Country
				System.out.println("Maximum Country Area is " + Data.max(measures));
			}
			if(classes == 3) { //Quiz
				System.out.println("Maximum Quiz Score is " + Data.max(measures));
			}
		}
		if(metrics == 2) { //Minimum
			if(classes == 1) { //BankAccount
				System.out.println("Minimum Account Balance is " + Data.min(measures));
			}
			if(classes == 2) { //Country
				System.out.println("Minimum Country Area is " + Data.min(measures));
			}
			if(classes == 3) { //Quiz
				System.out.println("Minimum Quiz Score is " + Data.min(measures));
			}
		}
		if(metrics == 3) { //Average
			if(classes == 1) { //BankAccount
				System.out.println("Average Account Balance is " + Data.average(measures));
			}
			if(classes == 2) { //Country
				System.out.println("Average Country Area is " + Data.average(measures));
			}
			if(classes == 3) { //Quiz
				System.out.println("Average Quiz Score is " + Data.average(measures));
			}
		}
	}

}
