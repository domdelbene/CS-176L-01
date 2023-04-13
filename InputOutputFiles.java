import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputFiles {
	
   public static void main(String[] args) throws FileNotFoundException {
	  Scanner scnr = new Scanner(System.in);
	  System.out.print("Please enter the path to open the input file for example C:\\Downloads\\lines.txt : ");
	  String input = scnr.nextLine();
	  
	  try {
		  File inputFile = new File(input);
		  PrintWriter outputFile = new PrintWriter("C:\\Users\\mysti\\Downloads\\outlines.txt");
     
		  Scanner in = new Scanner(inputFile);
		  while (in.hasNext()) {
			  String what = in.next();
			  outputFile.println(what);
		  }
		  in.close();
		  outputFile.close();
	  }
	  catch(FileNotFoundException e) {
		  e.printStackTrace();
		  System.out.println("File is not found, please try again");
	  }
   }
}
