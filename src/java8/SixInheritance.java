package java8;

interface Left {
	default void m1() {
		System.out.println("Left interface m1 method");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right interface m1 method");
	}
}

public class SixInheritance implements Left,Right {
	 
	public void m1() {
		//System.out.println("Our own m method");
		Left.super.m1();
		//Right.super.m1();
	}
	
	public static void main(String[] args) {
		SixInheritance sx=new SixInheritance();
		sx.m1();
	}

}
