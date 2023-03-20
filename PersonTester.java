/**
 * Implement a superclass Person. 
 * Make two classes, Student and Instructor, that inherit from Person. 
 * A person has a name and a year of birth.
 * A student has a major, and an instructor has a salary.
 * Write the class declarations and the constructors for all classes
 * 
 * This class tests the Person, Student, and Instructor classes.
*/
public class PersonTester
{
   public static void main(String[] args)
   {
	   Person p1 = new Person("John", 1965);
	   Person p2 = new Person("Mary Ann", 1970);
	   Student s1 = new Student("Ann", 1982, "Computer Science");
	   Student s2 = new Student("Thomas", 1986, "Biology");
	   Instructor i1 = new Instructor("Joseph", 1954, 65000);
	   
      /**
       * p1 is a Person "John" born in 1965
       * p2 is a Person "Mary Ann" born in 1970
       * s1 is a Student "Ann" born in 1982 and is a "Computer Science" major
       * s2 is a Student "Thomas" born in 1986 and is a "Biology" major
       * i1 is an Instructor "Joseph" born in 1954 earning 65000
       * Enter lines of code below to instantiate these objects:
       */


      /**
       * Leave the following lines 'as is' to verify that your results match the expected results
       */
      System.out.println(p1.toString());
      System.out.println("Expected: Person[name=John,birthYear=1965]");
      System.out.println("");
      
      System.out.println(p2.toString());
      System.out.println("Expected: Person[name=Mary Ann,birthYear=1970]");
      System.out.println("");
      
      System.out.println(s1.toString());
      System.out.println("Expected: Student[super=Person[name=Ann,birthYear=1982],major=Computer Science]");
      System.out.println("");
      
      System.out.println(s2.toString());
      System.out.println("Expected: Student[super=Person[name=Thomas,birthYear=1986],major=Biology]");
      System.out.println("");
      
      System.out.println(i1.toString());
      System.out.println("Expected: Instructor[super=Person[name=Joseph,birthYear=1954],salary=65000.0]");
   }
}
