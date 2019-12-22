package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Score;
import com.huangguibo.electivesystem.domain.Teacher;
import com.huangguibo.electivesystem.service.Cou_Ser;
import com.huangguibo.electivesystem.service.Tea_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddScore {
    @Autowired
    Tea_Ser tea_ser;
    @Autowired
    Cou_Ser cou_ser;
    @RequestMapping("/addScore")
    String addScorePage(@RequestParam long cid, @RequestParam long tid, Model model){
        model.addAttribute("teacher",tea_ser.getById(tid));
        model.addAttribute("c",cou_ser.getById(cid));
        model.addAttribute("courses",cou_ser.getCouByTid(tid));
        model.addAttribute("students",tea_ser.getScore(cid));
        model.addAllAttributes(tea_ser.getTotal(tid,cid));
        return "addScore";
    }
    @ResponseBody
    @PostMapping("/updateScore")
    Map<Integer,Integer> updateScore(@RequestBody List<Score> scores){
        for (Score s:scores) {
            tea_ser.updateScore(s.getGrade(),s.getSid(),s.getCid());
        }
        HashMap<Integer,Integer>  map = new HashMap<>();
        map.put(1,1);
       return map;
    }
}
