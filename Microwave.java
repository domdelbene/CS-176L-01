
public class Microwave {

	private int time;
	private int powerLevel;
	
	public Microwave() {
		time = 0;
		powerLevel = 1;
	}
	public void start() {
		System.out.println("Cooking for " + time + " seconds at level " + powerLevel + ".");
	}
	public void increaseTime() {
		time+= 30;
		System.out.println("Time Button was pressed. Time is " + time + " seconds.");
	}
	public void powerSwitch() {
		if(powerLevel == 1) {
			powerLevel+= 1;
			System.out.println("Power Button was pressed. Power level is " + powerLevel + ".");
		} else {
			powerLevel-= 1;
			System.out.println("Power Button was pressed. Power level is " + powerLevel + ".");
		}
	}
	public void reset() {
		time = 0;
		powerLevel = 1;
		System.out.println("Reset Button was pressed. Power level is " + powerLevel + ". Time is " + time + " seconds.");
	}
}
