package java8;

@FunctionalInterface
interface InterfaceDefault {
	public void m1();

	//Its not mandatory for a class to implement the default method
	//In case if we add normal method then its mandatory to implement by child class
	default void m2() {
		System.out.println("Default method");
	}

}

public class FourDefault implements InterfaceDefault {

	public static void main(String[] args) {
		FourDefault fd = new FourDefault();
		fd.m1();
		fd.m2();

	}

	@Override
	public void m1() {
		System.out.println("Overriding version of m1  default method");
	}
	
	public void m2() {
		System.out.println("Overriding version of m2 default method");
	}
}
