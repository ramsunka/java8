package java8;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		//Supplier is just returns the data
		Supplier<Date> s=() -> new Date();
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		
		Supplier<String> st=() ->{
			String otp="";
			for(int i=0;i<6;i++) {
				otp=otp+(int)(Math.random()*10);
			}
			return otp;
		};
		System.out.println(st.get());
		System.out.println(st.get());
		System.out.println(st.get());
	}

}
