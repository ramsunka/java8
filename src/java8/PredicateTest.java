package java8;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 * Normal predicate can take only one input argument and perform some conditional check.
 * Some times our programming requirement is we have to take 2 input arguments and perform
 * some conditional check, for this requirement we should go for BiPredicate
 * 
 * BiPredicate is exactly same as Predicate except that it will take 2 input arguments
 * */

class EmployeeT{
	String name;
	double salary;
	
	public EmployeeT(String name,double salary) {
		this.name=name;
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return this.name+"---"+this.salary;
	}
}
public class PredicateTest {
	
	public static void main(String[] args) {
		String[] slist= {"Nag","Chiranjeevi","Venky","Bala","Sunny","Katrina"};
		//Predicate is a functional interface
		//It is usefull to use where there is a conditional check
		Predicate<String> p=s1->s1.length()%2==0;
		for(String s1:slist) {
			if(p.test(s1)) {
				System.out.println(s1);
			}
		}
		
		ArrayList<EmployeeT> l=new ArrayList<EmployeeT>();
		l.add(new EmployeeT("Ram",1000));
		l.add(new EmployeeT("Bala",5000));
		l.add(new EmployeeT("Chiru",7000));
		l.add(new EmployeeT("King",1500));
		l.add(new EmployeeT("Bomg",1800));
		l.add(new EmployeeT("Chill",3000));
		l.add(new EmployeeT("Rmeo",16700));
		//Single predicate case
		Predicate<EmployeeT> p1= e->e.salary>3000;
		for(EmployeeT e1:l) {
			if(p1.test(e1)) {
				System.out.println(e1);
			}
		}
		
		
		//Multiple predicate case
		int[] x= {0,5,10,15,20,25,30,35};
		Predicate<Integer> pe= i->i%2==0;
		Predicate<Integer> pe1=j->j>10;
		//and(),or(),negate()
		System.out.println("The numbers which are even and >10 are :");
		for(int x1:x) {
			if(pe.or(pe1).test(x1)) {
				System.out.println(x1);
			}
		}
		
		//BiPredicate - It takes two values as input where as Predicate takes only one input
		BiPredicate<Integer, Integer> bip=(a,b)->(a+b)%2==0;
		
		System.out.println(bip.test(10, 10));
		System.out.println(bip.test(10, 25));
		System.out.println(bip.test(10, 40));
		
		
		System.out.println("-----BiFunction Example---");
		//BiFunction is useful in case of two input parameters
		BiFunction<Integer,String,EmployeeT> bif=(eno,name)->new EmployeeT(name, eno);
		l.add(bif.apply(250, "Ramesh"));
		l.add(bif.apply(250, "Shiva"));
		l.add(bif.apply(250, "Amar"));
		
		for(EmployeeT ef:l) {
				System.out.println(ef);
		}
		System.out.println("------BiConsumer Example----------");
		//BiConsumer example
		BiConsumer<EmployeeT,Double> cbi=(eb,db)->eb.salary=eb.salary+db;
		populate(l);
		for(EmployeeT et:l) {
			cbi.accept(et, 500.0);
		}
		for(EmployeeT ef:l) {
			System.out.println(ef);
		}
		
	}
	
	public static void populate(ArrayList<EmployeeT> l) {
		l.add(new EmployeeT("Bunny",10));
		l.add(new EmployeeT("Runny",105));
		l.add(new EmployeeT("Vunny",106));
	}

}
