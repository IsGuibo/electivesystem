package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.service.Stu_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Profile {
    @Autowired
    Stu_Ser stu_ser;
    @GetMapping("/Profile")
    String showProfile(@RequestParam(name ="id")long id, @RequestParam(required = false) String option,Model model){
        Student student = stu_ser.getStuById(id);
        model.addAttribute("student",student);
        model.addAttribute("sid",id);
        model.addAllAttributes(stu_ser.getCredit(id));
        model.addAttribute("termList",stu_ser.getTerm(id));
        if(option==null){
            model.addAttribute("gradeList",stu_ser.getGrade(id));
        }else {
            model.addAttribute("gradeList",stu_ser.getGrade(id,option));
            model.addAttribute("option",option);
            model.addAllAttributes(stu_ser.getCredit(id,option));
        }
        return "profile";
    }
}
