package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("101")
	private int id;
	
	@Value("97987567656")
	private long phone;
	
	@Value("92.5")
	private float marks;
	
	@Autowired
	Course c;
	
	public void display() {
		System.out.println("The id is"+id);
		System.out.println("The phone number is"+phone);
		System.out.println("The marks are"+marks);
		System.out.println("The course"+c.getCourseName());
	}
}
