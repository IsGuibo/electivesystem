package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.service.Cou_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CourseInfo {
    @Autowired
    Cou_Ser cou_ser;

    @RequestMapping("/Cou/getAll")
    List<Course> getAll(){
        return cou_ser.getAll();
    }

    @GetMapping("/Cou/getByCid")
    Course getById(@RequestParam(name = "cid") long cid){
        return cou_ser.getById(cid);
    }



}
