package com.huangguibo.electivesystem.service.serviceImpl;

import com.huangguibo.electivesystem.DAO.TeacherDao;
import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.domain.Teacher;
import com.huangguibo.electivesystem.service.Cou_Ser;
import com.huangguibo.electivesystem.service.Tea_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Tea_SerImpl implements Tea_Ser {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    Cou_Ser cou_ser;
    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public Teacher getById(Long tid) {
        return teacherDao.getByTid(tid);
    }

    @Override
    public List<Student> getScore(long cid) {
        return teacherDao.getScore(cid);
    }

    @Override
    public void updateScore(int grade, long sid, long cid) {
        teacherDao.updateScore(grade, sid, cid);
    }

    @Override
    public Map<String, Object> getTotal(long tid) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("sbjCount",teacherDao.getSbjCount(tid).get("sbjCount"));
        map.put("studentCount",teacherDao.getStudentCount(tid).get("studentCount"));
        map.put("avgRate",teacherDao.getPassRate2(tid).get("avgRate"));
        return map;
    }

    @Override
    public Map<String, Object> getTotal(long tid, long cid) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("credit",cou_ser.getById(cid).getCredit());
        map.put("studentCount",teacherDao.getStudentCount2(tid,cid).get("studentCount"));
        map.put("passRate",teacherDao.getPassRate(tid,cid).get("passRate"));
        return map;
    }

    @Override
    public List<String> getChoYear() {
        return teacherDao.getChoYear();
    }

    @Override
    public List<Course> getNoChoCou(String choYear) {
        return teacherDao.getNoChoCou(choYear);
    }

    @Override
    public List<Integer> getYearNum() {
        List<String> list = teacherDao.getChoYear();
        List<Integer> yearList = new ArrayList<>();
        for (String s : list) {
            yearList.add(teacherDao.getNoChoCou(s).size());
        }
        return yearList;
    }


}
