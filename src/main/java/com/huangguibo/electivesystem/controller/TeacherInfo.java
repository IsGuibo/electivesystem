package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Teacher;
import com.huangguibo.electivesystem.service.Tea_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherInfo {
    @Autowired
    Tea_Ser tea_ser;
    @RequestMapping("/Tea/getAll")
    List<Teacher> getAll(){
        return tea_ser.getAll();
    }
    @GetMapping("Tea/getByTid")
    Teacher getById(@RequestParam(name = "tid") long tid){
        return tea_ser.getById(tid);
    }
}
