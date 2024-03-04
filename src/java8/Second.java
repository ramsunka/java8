package java8;

import java.util.ArrayList;
import java.util.Collections;

class Employee{
	String name;
	int eno;
	Employee(String name,int eno){
		this.name=name;
		this.eno=eno;
	}
	public String toString() {
		return this.eno+":"+this.name;
	}
}

public class Second {

	public static void main(String[] args) {
		ArrayList<Employee> e=new ArrayList<Employee>();
		e.add(new Employee("QQ",12));
		e.add(new Employee("WW",123));
		e.add(new Employee("EE",124));e.add(new Employee("RR",125));
		e.add(new Employee("TT",122));
		System.out.println(e);
		Collections.sort(e,(e1,e2)->(e1.eno<e2.eno)?-1:(e1.eno>e2.eno)?1:0);
		System.out.println(e);
		Collections.sort(e,(e1,e2)->(e1.name.compareTo(e2.name)));
		System.out.println(e);
	}
}
