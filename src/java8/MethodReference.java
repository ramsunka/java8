package java8;

interface Reference{
	public void add(int a,int b);
}
public class MethodReference {
	public static void sum(int x,int y) {
		System.out.println("The sum: "+(x+y));
	}
	
	//Static method
	public static void m1() {
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread Method reference");
		}
	}
	//Instance method
	public void m2() {
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread Method reference");
		}
	}	
	
	
	public static void main(String[] args) {
		
		//Creating thread reference using lambda expression
		Runnable r =() ->{
			System.out.println("Child Thread Lambda 1");
		};
		
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread Lambda reference");
		}
		
		//Method reference - Case 1 is use full for static method
		Runnable r1 =MethodReference::m1;
		Thread t1=new Thread(r1);
		t1.start();
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread static Method reference");
		}
		
		//Method reference - Case 2 is use full for instance method
		MethodReference tob=new MethodReference();
		Runnable r2 =tob::m2;
		Thread t2=new Thread(r2);
		t2.start();
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread instance Method reference");
		}		
		
		//Case1-Interface method implementation using lambda expression
		Reference i=(a,b)->System.out.println("The Sum: "+(a+b));
		i.add(10, 20);
		
		//Method reference-Case2-Assign static method
		Reference i1=MethodReference::sum;
		i1.add(10, 20);
	}

}
