package java8;

class P1{
	public void m1() {
		System.out.println("P1 method");
	}
}
class P2{
	public void m2() {
		System.out.println("P2 method");
	}
}
//Java does not allow multiple inheritance but python supports it.
//Multiple inheritance means a Java class can extend only one class and implement multiple interfaces
//It fails with compile time error
public class FiveInheritance extends P1{
	
	public static void main(String[] args) {
		FiveInheritance fi=new FiveInheritance();
		fi.m1();
		
	}
	

}
