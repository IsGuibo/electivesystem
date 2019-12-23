package com.huangguibo.electivesystem.service;

import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface Tea_Ser {
    List<Teacher> getAll();

    Teacher getById(Long tid);

    List<Student> getScore(long cid);

    void updateScore(int grade, long sid, long cid);

    Map<String, Object> getTotal(long tid);

    Map<String, Object> getTotal(long tid, long cid);

    List<String> getChoYear();

    List<Course> getNoChoCou(String choYear);

    List<Integer> getYearNum();
}
