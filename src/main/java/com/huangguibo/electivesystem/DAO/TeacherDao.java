package com.huangguibo.electivesystem.DAO;

import com.huangguibo.electivesystem.domain.Course;
import com.huangguibo.electivesystem.domain.Student;
import com.huangguibo.electivesystem.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherDao {
    @Select("SELECT * FROM teacher")
    List<Teacher> getAll();

    @Select("Select * from teacher where tid = #{tid}")
    Teacher getByTid(long tid);
    @Select("SELECT student.`name`,student.sid,cid,grade,startyear,_class,sex FROM `sc` join student on sc.sid=student.sid where cid=${cid}")
    List<Student> getScore(long cid);
    @Update("UPDATE sc set grade = ${grade} WHERE sid = ${sid} and cid = ${cid}")
    int updateScore(int grade,long sid,long cid);
    @Select("SELECT COUNT(*) AS studentCount  FROM `sc` JOIN course on sc.cid = course.cid where teacher = ${tid}")//获取总学生
    Map<String,Integer> getStudentCount(long tid);
    @Select("SELECT COUNT(*) AS studentCount FROM `sc` JOIN course on sc.cid = course.cid where teacher = ${tid} and course.cid = ${cid}")//获取科目学生
    Map<String,Integer> getStudentCount2(long tid,long cid);
    @Select("SELECT COUNT(*) AS sbjCount FROM course WHERE teacher = ${tid}")
    Map<String,Integer> getSbjCount(long tid);
    @Select("SELECT passCount / studentCount AS passRate FROM(SELECT * FROM(SELECT teacher,course.cid,count(*) AS studentCount,count( CASE WHEN grade >= 60 THEN grade END ) AS passCount FROM sc JOIN course ON course.cid = sc.cid GROUP BY cid ) AS temp WHERE teacher = ${tid} AND cid = ${cid} ) AS temp2")
    Map<String,Integer> getPassRate(long tid,long cid);
    @Select("SELECT ROUND(AVG(passRate), 4) avgRate FROM(\n" +
            "SELECT passCount/studentCount as passRate FROM(\n" +
            "SELECT * \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tteacher,\n" +
            "\t\tcourse.cid,\n" +
            "\t\tcount(*) AS studentCount,\n" +
            "\t\tcount( CASE WHEN grade >= 60 THEN grade END ) AS passCount \n" +
            "\tFROM\n" +
            "\t\tsc\n" +
            "\t\tJOIN course ON course.cid = sc.cid \n" +
            "\tGROUP BY\n" +
            "\t\tcid \n" +
            "\t) AS temp \n" +
            "WHERE\n" +
            "\tteacher = ${tid}) AS temp2)As\n" +
            "\ttemp3")
    Map<String, Double> getPassRate2(long tid);

    @Select("SELECT choyear FROM sc GROUP BY choyear ORDER BY choyear")
    List<String> getChoYear();

    @Select("SELECT * FROM course WHERE cid  NOT in (SELECT cid From sc WHERE choyear ='${choYear}')")
    List<Course> getNoChoCou(String choYear);

    @Select("SELECT COUNT(*) FROM sc GROUP BY choyear")
    List<Integer> getYearNum();
}
