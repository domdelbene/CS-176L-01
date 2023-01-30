import java.util.Scanner;

public class HousePainting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalSqft = 0;
		double totalCost = 0.0;
		
		System.out.println("Please enter the cost per square foot: ");
		int costSqft = sc.nextInt();
		System.out.println("Please enter the length of the house: ");
		int lengthHouse = sc.nextInt();
		System.out.println("Please enter the width of the house: ");
		int widthHouse = sc.nextInt();
		System.out.println("Please enter the height of the house: ");
		int heightHouse = sc.nextInt();
		System.out.println("Please enter the number of windows: ");
		int numWindows = sc.nextInt();
		System.out.println("Please enter the length of a window: ");
		int windowLength = sc.nextInt();
		System.out.println("Please enter the width of a window: ");
		int windowWidth = sc.nextInt();
		System.out.println("Please enter the number of doors: ");
		int numDoors = sc.nextInt();
		System.out.println("Please enter the length of a door: ");
		int doorLength = sc.nextInt();
		System.out.println("Please enter the width of a door: ");
		int doorWidth = sc.nextInt();
		
		double peakSide = 0.0;
		double normalSide = 0.0;
		peakSide = lengthHouse * widthHouse + .5 * (lengthHouse * (heightHouse - widthHouse));
		normalSide = lengthHouse * widthHouse;
		peakSide *= 2;
		normalSide *= 2;
		totalSqft += peakSide + normalSide;
		
		double windowSqft = 0.0;
		double doorSqft = 0.0;
		windowSqft = numWindows * windowWidth * windowLength;
		doorSqft = numDoors * doorWidth * doorLength;
		totalSqft -= windowSqft + doorSqft;
		
		totalCost = totalSqft * costSqft;
		System.out.println("Your total paintable surface area is " + totalSqft + " square feet.");
		System.out.printf("Your estimate is %.0f dollars.\n", totalCost);

	}

}
