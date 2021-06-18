package com.example.soapmvn.endpoint;

import com.example.soap_mvn.GetUserRequest;
import com.example.soap_mvn.GetUserResponse;
//import com.example.soap_mvn.User;
/*
import com.javatechie.soapmvn.GetUserRequest;
import com.javatechie.soapmvn.GetUserResponse;
import com.javatechie.soapmvn.User;
*/
import com.example.soap_mvn.User;
import com.example.soapmvn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService ut;

    //private userservice userService;

   // private static final String NAMESPACE = "http://www.example.com/soap-mvn";

   /* @PayloadRoot( namespace = NAMESPACE,localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        //User us=  userService.getUsers(request.getName());
        //User us=  ust.getUsers("amit");
      //  System.out.println("111111111 : us : " + us);
        System.out.println("222222222 name:"+ request.getName());
     //   GetUserResponse resp = new GetUserResponse();
      //  resp.setUser(us);
       // System.out.println("333333333: resp:" + resp);

        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));

        return response;


    }*/

    @PayloadRoot(namespace = "http://www.example.com/soap-mvn",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
/*
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
*/

        User us=  ut.getUsers(request.getName());
        //User us=  ust.getUsersSaji("amit");
        System.out.println("111111111 : us : " + us);
        System.out.println("222222222 name:"+ request.getName());
        GetUserResponse resp = new GetUserResponse();
        resp.setUser(us);
        System.out.println("333333333: resp:" + resp);

        return resp;
    }
}
