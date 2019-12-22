package com.huangguibo.electivesystem.controller;

import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.domain.SelCouResult;
import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.service.Cou_Ser;
import com.huangguibo.electivesystem.service.Stu_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectCou {
    private long sid;
    @Autowired
    Cou_Ser cou_ser;
    @Autowired
    Stu_Ser stu_ser;
    @GetMapping("/selectCou")
    String selectCou(@RequestParam(name ="id")long id,@RequestParam(name = "searchText",required = false) String searchText, Model model){
        sid = id;
        List<Course> courses;
        Student student = stu_ser.getStuById(id);
        model.addAttribute("student",student);
        List<Course> sedCourses = cou_ser.getSedCou(id);
        if(searchText==null||searchText.equals("")){
            courses = cou_ser.getCanCho(id);
        }else {
            long cid;
            try {
                cid = Long.parseLong(searchText);
            }catch (Exception e){
                cid = -1;
            }
            courses = cou_ser.searchCou(searchText,cid,id);
        }
        model.addAttribute("courses",courses);
        model.addAttribute("sedCourses",sedCourses);
        return "selectCou";
    }
    @GetMapping("/selectCou/do")
    @ResponseBody
    public SelCouResult selectCou(@RequestParam(name = "cids") String cids){
        SelCouResult selCouResult = new SelCouResult();
        List<String> success =new ArrayList<>();
        List<String> fail = new ArrayList<>();
        String[] cid=cids.split(",");
        for(String s:cid){
            if(cou_ser.selectCou(sid,Long.parseLong(s)))
                success.add(cou_ser.getById(Long.parseLong(s)).getCname());
            else
                fail.add(cou_ser.getById(Long.parseLong(s)).getCname());
        }
        selCouResult.setSuccess(success);
        selCouResult.setFail(fail);
        return selCouResult;
    }



}
