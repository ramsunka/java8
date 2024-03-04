package java8;
interface InterfSeven {
	public static void m1() {
		System.out.println("Interface static method");
	}
}

public class SevenInterface implements InterfSeven {

	public static void main(String[] args) {
		InterfSeven.m1();

	}
}
