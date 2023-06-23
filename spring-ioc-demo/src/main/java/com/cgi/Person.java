package com.cgi;

public class Person {
	
	private String personId;
	private String personName;
	private Address address;
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", address=" + address + "]";
	}
	public Person(String personId, String personName, Address address) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.address = address;
	}

}
