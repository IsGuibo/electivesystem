package com.huangguibo.electivesystem.service;

import com.huangguibo.electivesystem.domain.Student;

import java.util.List;
import java.util.Map;

public interface Stu_Ser {
    List<Student> getAll();
    Student getStuById(long sid);
    Map<String,Float> getCredit(long sid);
    Map<String,Float> getCredit(long sid,String choyear);
    List<Map<String,Object>> getGrade(long sid);
    List<String> getTerm(long sid);
    List<Map<String,Object>> getGrade(long sid,String option);
}

