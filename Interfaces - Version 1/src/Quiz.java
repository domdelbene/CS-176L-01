
public class Quiz implements Measurable {

	private double score;
	
	public Quiz(double score) {
		this.score = score;
	}
	public double getMeasure() {
		return score;
	}
}
