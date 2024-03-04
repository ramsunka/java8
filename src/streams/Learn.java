package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		marks.add(5);
		marks.add(10);
		marks.add(15);
		marks.add(20);
		marks.add(205);
		System.out.println(marks);
		//stream and filter
		List<Integer> l2=marks.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(l2);
		//map and collect
		List<Integer> l3=l2.stream().map(n->n+5).collect(Collectors.toList());
		System.out.println(l3);
		//Count
		long noOfFailedStudents=marks.stream().filter(m->m<35).count();
		System.out.println(noOfFailedStudents);
		//sorted
		ArrayList<Integer> unsortedList = new ArrayList<Integer>();
		unsortedList.add(70);
		unsortedList.add(45);
		unsortedList.add(10);
		unsortedList.add(65);
		unsortedList.add(20);
		unsortedList.add(25);
		System.out.println("Unsorted ==>"+unsortedList);
		//Ascending order
		List<Integer> list=unsortedList.stream().sorted().collect(Collectors.toList());
		System.out.println("Ascending Order ==>"+list);
		//Default sorting order is working based Comparable Interface which has compareTo method
		List<Integer> clist=unsortedList.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println("Ascending Order==>"+clist);
		/*Customized Sorting
		 * sorted() ==> s1.compareTo(s2) ==>Default natural sorting order
		 * sorted(comparator) ==> Customized sorting order
		 *Comparator --> compare(obj1,obj2)
		 * returns -ve if obj1 has to come before obj2
		 * returns +ve if obj1 has to come after obj2
		 * returns 0 if obj1 and obj2 are equal
		 * 
		 * */
		//Descending Order
		List<Integer> declist=unsortedList.stream().sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
		System.out.println("Descending Order==>"+declist);
		
		
		//String array to apply streams
		ArrayList<String> ls=new ArrayList<>();
		ls.add("Sunny");
		ls.add("Kajal");
		ls.add("Prabhas");
		ls.add("Anushka");
		ls.add("Mallika");
		System.out.println("String list ==>"+ls);
		List<String> sortedStrings=ls.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted string list ==>"+sortedStrings);
		/*
		 * (s1,s2)->s1.compareTo(s2) ==> Natural Sorting Order
		 * (s1,s2)->s2.compareTo(s1) ==>Reverse of Natural Sorting Order
		 * (s1,s2)->-s1.compareTo(s2)==>Reverse of Natural Sorting Order
		 * 
		 * */
		System.out.println("String list ==>"+ls);
		List<String> sortedStrings1=ls.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());
		System.out.println("Sorted string list ==>"+sortedStrings1);
		System.out.println("<=========================>");
		ArrayList<String> strlist=new ArrayList<String>();
		strlist.add("A");
		strlist.add("AAAA");
		strlist.add("AA");
		strlist.add("AAAAA");
		strlist.add("AAA");
		strlist.add("BB");
		System.out.println(strlist);
		Comparator<String> c=(sl1,sl2)->{
			int le1=sl1.length();
			int le2=sl2.length();
			if(le1<le2) return -1;
			else if(le1>le2) return 1;
			else return sl1.compareTo(sl2);
		};
		List<String> cstring=strlist.stream().sorted(c).collect(Collectors.toList());
		System.out.println("Sorted string list using length ==>"+cstring);
		
		
		//Finding min and max value from list
		ArrayList<Integer> intl=new ArrayList<>();
		intl.add(10);intl.add(60);intl.add(15);intl.add(5);intl.add(20);
		Integer min=intl.stream().min((intl1,intl2)->intl1.compareTo(intl2)).get();
		System.out.println("Minuimum value is "+min);
		Integer max=intl.stream().max((intl1,intl2)->intl1.compareTo(intl2)).get();
		System.out.println("Maximum value is "+max);
		System.out.println("------------For Each example to print list ---------------------");
		intl.stream().forEach(System.out::println);
		 
		intl.stream().forEach(isq->{
			System.out.println("The square of "+isq+" is :"+(isq*isq));
		});
		System.out.println("------------convert List to Array ---------------------");
		Integer[] arri=intl.stream().toArray(Integer[]::new);
		//For each method is applicable for only streams not Arrays
		for(Integer i:arri) {
			System.out.println(i);
		}
		System.out.println("------------convert Array to Stream ---------------------");
		//Get the stream from Array
		Stream.of(arri).forEach(System.out::println);
		System.out.println("------------Reduce example ---------------------");
		//Reduce
		Integer sum=Stream.of(arri).reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
		 
	}

}
