package java8;

//Go to Constructor Reference if Method returns an object 
class Sample{
	/*
	 * Sample(){//No arg constructor
	 * System.out.println("Sample class Constructor Execution"); }
	 */
	Sample(String s){//No arg constructor
		System.out.println("Sample class Constructor Execution with argument - "+s);
	}
}
interface ConRef{
	//public Sample get();
	public Sample get1(String s);
}
public class ConstructoRefernce {

	public static void main(String[] args) {
		/*
		 * ConRef cr=Sample::new; 
		 * Sample s1=cr.get(); 
		 * Sample s2=cr.get(); 
		 * Sample s3=cr.get(); 
		 * Sample s4=cr.get();
		 */
		
		ConRef cr1=Sample::new;
		Sample s5=cr1.get1("Durga");
	}
}
