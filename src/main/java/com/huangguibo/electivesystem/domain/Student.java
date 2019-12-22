package com.huangguibo.electivesystem.domain;

public class Student {

  private long sid;
  private String name;
  private String sex;
  private String _class;
  private int startyear;
  private String password;
  private int grade;


  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String get_class() {
    return _class;
  }

  public void set_class(String _class) {
    this._class = _class;
  }


  public int getStartyear() {
    return startyear;
  }

  public void setStartyear(int startyear) {
    this.startyear = startyear;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
}
