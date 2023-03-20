/**
   An instructor is represented by a name, a birth year, and a salary.
   You must enter the class name, instance variable(s), and constructor below
*/




   /**
      Returns the string represention of the object.
      @return a string representation of the object
   */
	
public class Instructor extends Person {
	
	private double salary;
	
	public Instructor(String name, int year, double salary) {
		super(name,year);
		this.salary = salary;
	}
	
	public String toString()
	{
      return "Instructor[super=" + super.toString() + ",salary=" + salary + "]";
	}
}