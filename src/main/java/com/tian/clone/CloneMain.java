package com.tian.clone;

public class CloneMain {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Name name = new Name("tian", "m");
		Person p1 = new Person(2, name);
		
		Person p2 = (Person) p1.clone();
		System.out.println(p1 + "\t" + p2);
		System.out.println("p1 == p2 " + (p1 == p2));
		System.out.println("p1.equals(p2) " + p1.equals(p2));
		System.out.println(p1.getName() == p2.getName());
		System.out.println(p1.getName().equals(p2.getName()));
		
		p2.setTall(3);
		p2.getName().setFirstname("sxx");
		p2.getName().setLastname("s");
		
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
