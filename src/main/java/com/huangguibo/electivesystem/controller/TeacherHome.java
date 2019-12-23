package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Teacher;
import com.huangguibo.electivesystem.service.Cou_Ser;
import com.huangguibo.electivesystem.service.Tea_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherHome {
    @Autowired
    Tea_Ser tea_ser;
    @Autowired
    Cou_Ser cou_ser;
    @GetMapping("/TeacherMag")
    String TeacherMag(@RequestParam(name = "id") long id,@RequestParam(required = false)String option, Model model){
        Teacher teacher = tea_ser.getById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("courses", cou_ser.getCouByTid(id));
        model.addAllAttributes(tea_ser.getTotal(id));
        model.addAttribute("ChoYears", tea_ser.getChoYear());
        if (option == null)
            model.addAttribute("noChoCou", tea_ser.getNoChoCou("2019-2020上"));
        else
            model.addAttribute("noChoCou", tea_ser.getNoChoCou(option));
        model.addAttribute("option", option);
        model.addAttribute("yearList", tea_ser.getYearNum());
        return "teacherMag";
    }
}
