package com.huangguibo.electivesystem.DAO;

import com.huangguibo.electivesystem.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CourseDao {
    @Select("SELECT * FROM course join teacher where course.teacher = teacher.tid")
    @Results({
            @Result(property = "teacher", column = "name"),
    })
    List<Course> getAll();

    @Select("Select * from course where cid = #{cid}")
    Course getByCid(long cid);

    @Select("SELECT * FROM student")
    List<HashMap> getC_T();
    @Insert("INSERT INTO sc (sid,cid) VALUES (#{sid},#{cid})")
    int addSc(long sid,long cid);

    @Select("SELECT course.cid,cname,credit,time,introduction,teacher.`name` as 'teacher' FROM course JOIN sc ON course.cid = sc.cid JOIN teacher ON teacher.tid = course.teacher WHERE sid = #{sid}")
    List<Course> getSelCou(long sid);

    @Select("SELECT course.cid,cname,credit,time,introduction,teacher.`name` as 'teacher' FROM course JOIN teacher On teacher.tid =course.teacher WHERE cid not in( SELECT cid FROM sc WHERE sid = #{sid} ) AND time not in(SELECT time FROM sc JOIN course c ON sc.cid = c.cid WHERE sid = #{sid} )")
    List<Course> getCanCho(long sid);
    @Update("UPDATE course SET capacity = capacity-1 WHERE cid = #{cid}")
    void updateCap(long cid);
    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tcourse.cid,\n" +
            "\t\tcname,\n" +
            "\t\tcredit,\n" +
            "\t\ttime,\n" +
            "\t\tintroduction,\n" +
            "\t\tteacher.`name`,\n" +
            "\t\tcapacity AS 'teacher' \n" +
            "\tFROM\n" +
            "\t\tcourse\n" +
            "\t\tJOIN teacher ON teacher.tid = course.teacher \n" +
            "\tWHERE\n" +
            "\t\tcid NOT IN ( SELECT cid FROM sc WHERE sid = #{sid} ) \n" +
            "\t\tAND time NOT IN ( SELECT time FROM sc JOIN course c ON sc.cid = c.cid WHERE sid = #{sid} ) \n" +
            "\t) AS cancho \n" +
            "WHERE\n" +
            "\tteacher LIKE '%${searchText}%' \n" +
            "\tOR cname LIKE '%${searchText}%' \n" +
            "\tOR cid = #{cid} \n" +
            "\tOR time LIKE '%${searchText}%'")
    List<Course> searchCou(String searchText,long cid,long sid);
    @Select("SELECT course.cid,cname,credit,time,introduction,teacher.`name` as 'teacher' FROM course JOIN teacher On teacher.tid =course.teacher JOIN sc on sc.cid = course.cid\n" +
            "WHERE tid = ${tid} AND course.cid in (SELECT cid FROM sc GROUP BY cid) GROUP BY course.cid")
    List<Course> getCouByTid(long tid);

}
