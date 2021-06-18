package com.example.soapmvn.service;

import com.example.soap_mvn.User;
//import com.javatechie.soapmvn.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<String,User>();

    @PostConstruct
     public void init(){
       User ut = new User();
        ut.setEmpId(21);
        ut.setName("rahul");
        ut.setSalary(11000);

        User ut2 = new User();
        ut2.setEmpId(23);
        ut2.setName("amit");
        ut2.setSalary(21000);

        users.put(ut.getName(),ut);
        users.put(ut2.getName(),ut2);

        /*User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(1112);
        sam.setSalary(32000);
        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(1113);
        ryan.setSalary(16000);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);*/
    }

    public User getUsers(String name){
        return users.get(name);
    }
}
