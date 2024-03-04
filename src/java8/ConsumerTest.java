package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Studentt {
	String name;
	int marks;
	public Studentt(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return this.name + "---" + this.marks;
	}
} 
class Movie{
	String name;
	public Movie(String name) {
		this.name=name;
	}
}

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);

		c.accept("Welcome");
		c.accept("India");
		Function<Studentt, String> f = s4 -> {
			int marks = s4.marks;
			String grade = "";
			if (marks >= 80) grade = "A-Distinction";
			else if (marks >= 60) grade = "B-FirstClass";
			else if (marks >= 50) grade = "C-Second Class";
			else if (marks >= 35) grade = "D-Third Class";
			else grade = "E-Failed";
			return grade;
		};
		

		//This predicate is being used to filter out the object array
		Predicate<Studentt> ps = s1 -> s1.marks >= 60;
		//Consumer to print the values
		Consumer<Studentt> c1= s2 ->{
			System.out.println(s2);
			System.out.println(f.apply(s2));
		};
		
		Studentt[] st1 ={ new Studentt("Durga", 100), 
				new Studentt("Sunny", 65), 
				new Studentt("Bunny", 55),
				new Studentt("Chinny", 45), 
				new Studentt("Vinny", 25) };
		
		for(Studentt st:st1) {
			if(ps.test(st)) {
				c1.accept(st);
			}
		}
		System.out.println("-------------");
		Consumer<Movie> c2=m->System.out.println(m.name+" Ready to Release");
		Consumer<Movie> c3=m->System.out.println(m.name+" Released but its bigger flop");
		Consumer<Movie> c4=m->System.out.println(m.name+" storing information in database");
		//Consumer chaining
		Consumer<Movie> cc=c2.andThen(c3).andThen(c4);
		Movie m=new Movie("Spider");
		cc.accept(m);
		
		
		
		
	}

}
