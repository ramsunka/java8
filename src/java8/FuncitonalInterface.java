package java8;

import java.util.function.Function;
import java.util.function.Predicate;

/*
Predicate,Function and Consumer,Supplier
-------------------------------------
Take some input and perform some conditional check and return boolean value -->Predicate
Take some input and perform some operation and return the result which is need not be boolean type --> Function
Accept some input and perform required operation and not required to return anything -->Consumer
Just supply my required objects and it wont take any input -->Supplier
Predicate --->test() -->Always takes input return type boolean
Function  --->apply()  -->It takes one input and  return function result
Consumer  --->accept() -->one input and Always return void
Supplier  --->get()  -->Wont take input

BiPredicate -->test()  -->Takes two inputs and returns boolean
BiFunction --->apply()  --> it takes two input and  return function result
BiConsumer --->accept()  --->two inputs - one input and second result

Primitive Predicate Types:
-------------------------
IntPredicate
DoublePredicate
LongPredicate
Primitive version of two arguments is not available so we should go for BiPredicate

Primitive Function Types:
-----------------------
It can take input type as primitive and return any type of value
DoubleFunction
IntFunction
LongFunction



*/
class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return this.name + "---" + this.marks;
	}
}

public class FuncitonalInterface {
	// Example of functional interface Function
	// It contains only apply method
	public static void main(String[] args) {
		Function<Integer, Integer> f = i -> i * i;
		System.out.println(f.apply(4));
		System.out.println(f.apply(5));

		// Length of the string
		Function<String, Integer> f1 = s1 -> s1.length();
		System.out.println(f1.apply("qwqwqwq"));

		// Convert to Uppercase of the string
		Function<String, String> f2 = s2 -> s2.toUpperCase();
		System.out.println(f2.apply("ramesh"));
		
		//This predicate is being used to filter out the object array
		Predicate<Student> ps= s3->s3.marks>=60;
				
		Function<Student, String> f3 = s4 -> {
			int marks = s4.marks;
			String grade = "";
			if (marks >= 80) grade = "A-Distinction";
			else if (marks >= 60) grade = "B-FirstClass";
			else if (marks >= 50) grade = "C-Second Class";
			else if (marks >= 35) grade = "D-Third Class";
			else grade = "E-Failed";
			return grade;
		};
		Student[] st ={ new Student("Durga", 100), 
						new Student("Sunny", 65), 
						new Student("Bunny", 55),
						new Student("Chinny", 45), 
						new Student("Vinny", 25) };

		for (Student s5 : st) {
			if(ps.test(s5)) {
			System.out.println("Student Details - " + s5.toString());
			System.out.println("Student Grade - " + f3.apply(s5));
			}
		}
		//Example of andThen function
		//first executes f11 then f12
		Function<Integer,Integer> f11=i->2*i;
		Function<Integer,Integer> f12=i->i*i*i;
		System.out.println(f11.andThen(f12).apply(2));
		//First f12 executes then f11 executes
		//Function chaining
		System.out.println(f11.compose(f12).apply(2));
		
		
		/*
		 * Predicate<T>  --> Returns boolean and it has only one function called test
		 * Function<T,R> --> Return type is R and it has apply,andThen and compose method
		 * Consumer<T>   --> It wont return anything so it means void
		 * 
		 * */
		
	}

}
