import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DonationsTester {

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File("Donations.txt");
		Scanner in = new Scanner(inputFile);
		Scanner scnr = new Scanner(System.in);
		Donations giveToMe = new Donations();
		
		System.out.println("Would you like to process donations now? (enter 'Yes' to continue): ");
		if(scnr.nextLine().equals("Yes")) {
			while(in.hasNextLine()) {
				String what = in.nextLine();
				if(what.startsWith("<individual donation>")) {
					double donation = Double.parseDouble(what.replaceAll("<individual donation>","")); //what.replaceAll("[^0-9.]","")
					giveToMe.processDonation("<individual donation>", donation);
				}
				else if(what.startsWith("<business donation>")) {
					double donation = Double.parseDouble(what.replaceAll("<business donation>",""));
					giveToMe.processDonation("<business donation>", donation);
				}
				else if(what.startsWith("<other donation>")){
					double donation = Double.parseDouble(what.replaceAll("<other donation>",""));
					giveToMe.processDonation("<other donation>", donation);
				}
				else {
					giveToMe.getStatistics();
				}
			}
		}
		else {
			System.out.println("Ending now without processing donations");
		}
	}

}
