package com.revature.operations;

import com.revature.models.Role;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamingFun {
	
	public static void main(String[] args) {
		
		
//		IntStream randInt = new SplittableRandom().ints(12, 18, 80);
		Supplier<Double> randInt = () -> Math.floor(Math.random()*100 + 1);
		
		List<User> users = new ArrayList<>();
		
		User u1 = new User(1, "dan", "pass", randInt.get(), Role.ADMIN);
		User u2 = new User(2, "pete", "pass", randInt.get(), Role.BASIC);
		User u3 = new User(3, "alice", "pass", randInt.get(), Role.PRO);
		User u4 = new User(4, "maya", "pass", randInt.get(), Role.BASIC);
		User u5 = new User(5, "anna", "pass", randInt.get(), Role.BASIC);
		User u6 = new User(6, "leo", "pass", randInt.get(), Role.BASIC);
		User u7 = new User(7, "jordan", "pass", randInt.get(), Role.PRO);
		User u8 = new User(8, "henry", "pass", randInt.get(), Role.PRO);
		User u9 = new User(9, "melissa", "pass", randInt.get(), Role.ADMIN);
		User u10 = new User(10, "patrice", "pass", randInt.get(), Role.BASIC);
		User u11 = new User(11, "greg", "pass", randInt.get(), Role.BASIC);
		User u12 = new User(12, "john", "pass", randInt.get(), Role.PRO);

		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		users.add(u6);
		users.add(u7);
		users.add(u8);
		users.add(u9);
		users.add(u10);
		users.add(u11);
		users.add(u12);
		
//		System.out.println(users);
//		for (User u : users) {
//			System.out.println(u);
//		}
	
		System.out.println("*************************All Users***************************");
		users.forEach(System.out::println);

//		randInt.forEach(i -> System.out.println(i));
		
		//System.out.println(randInt.findAny().getAsInt());
		
		System.out.println("*************************All Users older than 40***************************");
		users.stream().filter(u->u.getAge() > 40).forEach(System.out::println);
		
		
		System.out.println("*************************All Admin Users***************************");
		List<User> admin = users.stream().filter(u->u.getRole().equals(Role.ADMIN)).collect(Collectors.toList());
		admin.forEach(System.out::println);;
		
		//users.stream().
		
	}
	

}
