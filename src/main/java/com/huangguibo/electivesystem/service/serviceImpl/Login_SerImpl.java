package com.huangguibo.electivesystem.service.serviceImpl;

import com.huangguibo.electivesystem.DAO.StudentDao;
import com.huangguibo.electivesystem.DAO.TeacherDao;
import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.domain.Teacher;
import com.huangguibo.electivesystem.service.Login_Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_SerImpl implements Login_Ser {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Override
    public int login(long id, String psw) {
        Student s = studentDao.getBySid(id);
        if (s != null)
            return s.getPassword().equals(psw)?1:0;
        else {
            Teacher t = teacherDao.getByTid(id);
            if (t != null)
                return t.getPassword().equals(psw) ?2:0;
        }
        return 0;
    }
}
