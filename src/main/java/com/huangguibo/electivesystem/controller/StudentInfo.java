package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.huangguibo.electivesystem.service.Stu_Ser;

import java.util.List;

@RestController
public class StudentInfo {
    @Autowired
    private Stu_Ser stu_service;
    @RequestMapping("/Stu/getAll")
    List<Student> hello(){
        return stu_service.getAll();
    }
    @GetMapping("/Stu/getBySid")
    public Student getById(@RequestParam(name = "sid") Long sid) {
        return stu_service.getStuById(sid);
    }
}
