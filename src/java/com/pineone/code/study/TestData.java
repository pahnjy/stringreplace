package com.pineone.code.study;

/**
 * Created by pahnj on 2015-12-17.
 */
public class TestData {
    String userid;
    String time;
    String week;

    public TestData(String userid, String time, String week) {
        this.userid = userid;
        this.time = time;
        this.week = week;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
