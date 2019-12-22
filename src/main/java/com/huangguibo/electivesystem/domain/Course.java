package com.huangguibo.electivesystem.domain;


public class Course {

  private long cid;
  private String cname;
  private float credit;
  private String introduction;
  private String time;
  private String teacher;
  private int capacity;



  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public float getCredit() {
    return credit;
  }

  public void setCredit(float credit) {
    this.credit = credit;
  }


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }


  public int getCount() {
    return capacity;
  }

  public void setCount(int count) {
    this.capacity = count;
  }
}
