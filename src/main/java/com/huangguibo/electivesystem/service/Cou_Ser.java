package com.huangguibo.electivesystem.service;

import com.huangguibo.electivesystem.domain.Course;

import java.util.HashMap;
import java.util.List;

public interface Cou_Ser {
    List<Course> getAll();
    Course getById(long cid);
    List<HashMap> getC_T();
    boolean selectCou(long sid,long cid);
    List<Course> getSedCou(long sid);
    List<Course> getCanCho(long sid);
    List<Course> searchCou(String searchText,long cid,long sid);
    List<Course> getCouByTid(long tid);
}
