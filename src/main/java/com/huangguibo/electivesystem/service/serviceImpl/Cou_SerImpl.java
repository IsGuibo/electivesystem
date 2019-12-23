package com.huangguibo.electivesystem.service.serviceImpl;

import com.huangguibo.electivesystem.DAO.CourseDao;
import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.service.Cou_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class Cou_SerImpl implements Cou_Ser {
    @Autowired
    CourseDao courseDao;
    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public Course getById(long cid) {
        return courseDao.getByCid(cid);
    }

    @Override
    public List<HashMap> getC_T() {
        return courseDao.getC_T();
    }

    @Override
    public boolean selectCou(long sid, long cid) {
        try {
            courseDao.addSc(sid,cid);
            courseDao.updateCap(cid);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Course> getSedCou(long sid) {
        return courseDao.getSelCou(sid);
    }

    @Override
    public List<Course> getCanCho(long sid) {
        return courseDao.getCanCho(sid);
    }

    @Override
    public List<Course> searchCou(String searchText,long cid,long sid) {
        return courseDao.searchCou(searchText,cid,sid);
    }

    @Override
    public List<Course> getCouByTid(long tid) {
        return courseDao.getCouByTid(tid);
    }
}
