package com.pineone.code.study;

/**
 * Created by pahnj on 2015-12-06.
 */
public class InputData {

    String value;
    String before;
    String after;

    public InputData() {
    }

    public InputData(String value, String before, String after) {
        this.value = value;
        this.before = before;
        this.after = after;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
