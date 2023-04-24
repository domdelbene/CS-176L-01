
public class Player {
	
	private String name;
	private int number;
	private int total;
	private int quantity;
	private double average;

	public Player(String name, int num) {
		this.name = name;
		number = num;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public int getTotal() {
		return total;
	}
	public double getAverage() {
		return average;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int num) {
		quantity = num;
	}
	public void addTotal(int num) {
		total += num;
	}
	public void calcAverage() {
		double avg =  (double) total / quantity;
		average = avg;
	}
}
