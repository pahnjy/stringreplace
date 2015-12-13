package com.pineone.code.study;

import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by pahnj on 2015-12-13.
 */
@Service
public class DateFormatter implements IDateFormatter{


    public static final String YEAR = "yyyy";
    public static final String MOUNTH = "MM";
    public static final String DATE = "dd";
    public static final String HOUR = "hh";
    public static final String MINUTE = "mm";
    public static final String SEOUND = "ss";
    public static final String AM_PM = "aa";
    public static final String AM = "AM";
    public static final String PM = "PM";
    public static final int PM_TIME = 12;
    Calendar calendar = Calendar.getInstance();

    @Override
    public String getDate(Calendar calendar, String type) {
        String dataValue = dateMapping(calendar, type);

        return dataValue;
    }

    private String dateMapping(Calendar calendar, String type) {
        String dataValue = type;

        if(type.contains(YEAR)){
            dataValue = dataValue.replace(YEAR, Integer.toString(calendar.get(Calendar.YEAR)));
        }
        if(type.contains(MOUNTH)){
            dataValue = dataValue.replace(MOUNTH, Integer.toString(calendar.get(Calendar.MONTH)+1));
        }
        if(type.contains(DATE)){
            dataValue = dataValue.replace(DATE, Integer.toString(calendar.get(Calendar.DATE)));
        }
        if(type.contains(HOUR)){
            if(!type.contains(AM_PM)){
                if(calendar.get(Calendar.AM_PM) == 0)
                {
                    dataValue = dataValue.replace(HOUR, Integer.toString(calendar.get(Calendar.HOUR)));
                } else
                {
                    dataValue = dataValue.replace(HOUR, Integer.toString(calendar.get(Calendar.HOUR)+ PM_TIME));
                }
            } else {
                dataValue = dataValue.replace(HOUR, Integer.toString(calendar.get(Calendar.HOUR)));
            }

        }
        if(type.contains(MINUTE)){
            dataValue = dataValue.replace(MINUTE, Integer.toString(calendar.get(Calendar.MINUTE)));
        }
        if(type.contains(SEOUND)){
            dataValue = dataValue.replace(SEOUND, Integer.toString(calendar.get(Calendar.SECOND)));
        }
        if(type.contains(AM_PM)){
            if(calendar.get(Calendar.AM_PM) == 0)
            {
                dataValue = dataValue.replace(AM_PM,AM);
            } else
            {
                dataValue = dataValue.replace(AM_PM,PM);
            }
        }
        return dataValue;
    }

}
