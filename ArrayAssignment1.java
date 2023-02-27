
public class ArrayAssignment1 {

	public static void main(String[] args) {
		
		double[] values = {25.3, 100, -10, -1.5, 13, 98.6, 17, 123.145, 125.6, 123.146};
		double max = 0;
		int negative = 0;

		for(int i = 0; i < values.length; i++) {
			if(max < values[i]) {
				max = values[i];
			}
			if(values[i] < 0) {
				negative++;
			}
			System.out.print(values[i] + " ");
		}
		System.out.println();
		System.out.println("The largest element in the array is " + max);
		System.out.println("There are " + negative + " negative numbers in the array");
	}

}
