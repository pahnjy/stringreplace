package com.pineone.code.study.stringutil.stringreplace;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-06.
 * 문자열 치환
 * 입력 소스(original) 문자열에서 특정 문자열1을 문자열2로 치환하는 API
 */
@Service
public class StringReplace implements IStringReplace {

    @Override
    public String replaceString(String value, String before, String after) {

        if(value.indexOf(before) == -1){
            return value;
        }


        String orgValue = value;
        String tempString = "";
        String changeValue = "";

        while (orgValue.indexOf(before) != -1){

            tempString = orgValue.substring(0,orgValue.indexOf(before));
            changeValue = changeValue.concat(tempString).concat(after);
            orgValue = orgValue.substring(orgValue.indexOf(before) + before.length(), orgValue.length());
        }
        if(orgValue.length() != 0){
            changeValue.concat(orgValue);
        }



        if(changeValue.length() == 0){
            return orgValue;
        } else {
            return changeValue.concat(orgValue);
        }

    }


}
