package com.revature.streams;

import com.revature.streams.models.Role;
import com.revature.streams.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingFun {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        User u1 = new User(1, "dan", "pass", 22, Role.ADMIN);
        User u2 = new User(2, "pete", "pass", 34, Role.BASIC);
        User u3 = new User(3, "alice", "pass", 44, Role.PRO);
        User u4 = new User(4, "maya", "pass", 32, Role.BASIC);
        User u5 = new User(5, "anna", "pass", 65, Role.BASIC);
        User u6 = new User(6, "leo", "pass", 77, Role.BASIC);
        User u7 = new User(7, "jordan", "pass", 55, Role.PRO);
        User u8 = new User(8, "henry", "pass", 68, Role.PRO);
        User u9 = new User(9, "melissa", "pass", 54, Role.ADMIN);
        User u10 = new User(10, "patrice", "pass", 61, Role.BASIC);
        User u11 = new User(11, "greg", "pass", 25, Role.BASIC);
        User u12 = new User(12, "john", "pass", 38, Role.PRO);


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

        users.stream().filter(u -> u.getAge() > 40).forEach(System.out::println);

        List<User> adminUsers = users.stream().filter(u -> u.getRole().equals(Role.ADMIN)).collect(Collectors.toList());

        adminUsers.forEach(System.out::println);


    }

}
