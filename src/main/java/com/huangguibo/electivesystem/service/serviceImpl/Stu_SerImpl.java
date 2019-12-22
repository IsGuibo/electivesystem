package com.huangguibo.electivesystem.service.serviceImpl;

import com.huangguibo.electivesystem.DAO.StudentDao;
import com.huangguibo.electivesystem.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.huangguibo.electivesystem.service.Stu_Ser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Stu_SerImpl implements Stu_Ser {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getStuById(long sid) {
        return studentDao.getBySid(sid);
    }

    @Override
    public Map<String, Float> getCredit(long sid) {
        HashMap<String,Float> map = new HashMap<>();
        map.putAll(studentDao.getObtainedCredit(sid));
        map.putAll(studentDao.getSumCredit(sid));
        map.putAll(studentDao.getLostCredit(sid));
        return map;
    }

    @Override
    public Map<String, Float> getCredit(long sid, String choyear) {
        HashMap<String,Float> map = new HashMap<>();
        map.putAll(studentDao.getObtainedCredit2(sid,choyear));
        map.putAll(studentDao.getSumCredit2(sid,choyear));
        map.putAll(studentDao.getLostCredit2(sid,choyear));
        System.out.println(map.toString());
        return map;
    }

    @Override
    public List<Map<String, Object>> getGrade(long sid) {
        return studentDao.getGrade(sid);
    }

    @Override
    public List<String> getTerm(long sid) {
        return studentDao.getTerm(sid);
    }

    @Override
    public List<Map<String, Object>> getGrade(long sid, String option) {
        return studentDao.getGrade2(sid,option);
    }
}
