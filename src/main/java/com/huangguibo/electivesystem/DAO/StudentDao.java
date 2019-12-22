package com.huangguibo.electivesystem.DAO;

import com.huangguibo.electivesystem.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentDao {
    @Select("SELECT * FROM student")
    List<Student> getAll();

    @Select("Select * from student where sid = #{sid}")
    Student getBySid(long sid);

    @Select("SELECT IFNULL(SUM(credit),0) AS sumCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid}")
    Map<String,Float> getSumCredit(long sid);

    @Select("SELECT IFNULL(SUM(credit),0) AS obtainedCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid} AND grade>=60")
    Map<String,Float> getObtainedCredit(long sid);

    @Select("SELECT IFNULL(SUM(credit),0) AS lostCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid} AND grade<60")
    Map<String,Float> getLostCredit(long sid);

    @Select("SELECT course.cname,course.credit,sc.grade FROM course JOIN sc ON course.cid = sc.cid WHERE sc.sid = ${sid} AND grade !=0")
    List<Map<String,Object>> getGrade(long sid);
    @Select("SELECT choyear FROM sc WHERE sid = ${sid} GROUP BY choyear")
    List<String> getTerm(long sid);
    @Select("SELECT course.cname,course.credit,sc.grade FROM course JOIN sc ON course.cid = sc.cid WHERE sc.sid = ${sid} AND grade !=0 AND choyear = '${option}'")
    List<Map<String,Object>> getGrade2(long sid,String option);
    @Select("SELECT IFNULL(SUM(credit),0) AS _lostCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid} AND grade<60 AND choyear = '${choyear}'")
    Map<String,Float> getLostCredit2(long sid,String choyear);
    @Select("SELECT IFNULL(SUM(credit),0) AS _obtainedCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid} AND grade>=60 AND choyear = '${choyear}'")
    Map<String,Float> getObtainedCredit2(long sid,String choyear);
    @Select("SELECT IFNULL(SUM(credit),0) AS _sumCredit FROM sc JOIN course ON course.cid = sc.cid WHERE sid = ${sid} AND choyear = '${choyear}'")
    Map<String,Float> getSumCredit2(long sid,String choyear);

}
