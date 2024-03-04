package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class First {
	public static void main(String[] args) {
		 Comparator<Integer> mc=(i1,i2)->(i1<i2)?1:(i1>i2)?-1:0;
		 ArrayList<Integer> l=new ArrayList<Integer>();
		 l.add(1);l.add(14);l.add(11);l.add(81);l.add(41);l.add(51);l.add(91);
		 System.out.println(l);
		 Collections.sort(l,mc);
		 System.out.println(l);
		 l.stream().forEach(System.out::println);
		 List<Integer> l2= l.stream().filter(i->i%2==0).collect(Collectors.toList());
		 System.out.println(l2);
	}
	
	

}
