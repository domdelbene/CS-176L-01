
public class Donations {

	private int numIndividual;
	private double amtIndividual;
	private int numBusiness;
	private double amtBusiness;
	private int numOther;
	private double amtOther;
	
	public void processDonation(String cat, double donation) {
		if(cat.startsWith("<individual donation>")) {
			amtIndividual += donation;
			if(donation > 0) {
				numIndividual++;
			} else {
				numIndividual--;
			}
		} 
		else if(cat.startsWith("<business donation>")) {
			amtBusiness += donation;
			if(donation > 0) {
				numBusiness++;
			} else {
				numBusiness--;
			}
		}
		else {
			amtOther += donation;
			if(donation > 0) {
				numOther++;
			} else {
				numOther--;
			}
		}
	}
	public void getStatistics() {
		System.out.println("Individual: #:" + numIndividual + " $" + amtIndividual);
		System.out.println("Business: #:" + numBusiness + " $" + amtBusiness);
		System.out.println("Other: #:" + numOther + " $" + amtOther);
	}
}
