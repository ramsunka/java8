package java8;

public class PrimeInt {
	//wrapper class creates object - heap memory
	//primitive type stores in memory- stack
	public static void compare(Integer a, int b) {
	    if (a.equals(b)) {
	      System.out.println("a and b are equal");
	    }
	    else {
	      System.out.println("a and b are not equal");
	    }
	  }
	public static void main(String[] args) {
	    int a = 1000;
	    int b = 1000;
	    compare(a,b);
	  }
}
