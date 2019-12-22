package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Login;
import com.huangguibo.electivesystem.service.Login_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Index {
    @Autowired
    Login_Ser login_ser;
    @PostMapping("/login")
    Map<Integer,Integer> login(@RequestBody(required = false) Login login){

        int user = login_ser.login(login.getId(),login.getPsw());
        System.out.println(user);
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        hashMap.put(user,0);
        return hashMap;
    }

}
