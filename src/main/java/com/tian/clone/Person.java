package com.tian.clone;

public class Person implements Cloneable {
	private int tall;
	private Name name;
	
	public Person(int tall, Name name) {
		super();
		this.tall = tall;
		this.name = name;
	}
	public int getTall() {
		return tall;
	}
	public void setTall(int tall) {
		this.tall = tall;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
//		return (Person) super.clone(); //浅克隆
		
//		Person person = (Person) super.clone();
//		Name name = new Name(this.name.getFirstname(), this.name.getLastname());
//		person.setName(name);
//		return person;
		
		Person person = (Person) super.clone();
		Name name = (Name) this.name.clone();
		person.setName(name);
		return person;
		
	}
	@Override
	public String toString() {
		return "Person [tall=" + tall + ", name=(" + name.getFirstname() + "," + name.getLastname() + ")]";
	}
}
