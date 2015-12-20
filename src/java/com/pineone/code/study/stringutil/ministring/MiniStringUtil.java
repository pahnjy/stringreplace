package com.pineone.code.study.stringutil.ministring;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-06.
 */
@Service
public class MiniStringUtil implements IMiniStringUtil {


    @Override
    public String changeExpression(String value, String places) {

        String expressionData = "";

        for(int i = 0; i < Integer.parseInt(places) - value.length(); i++){
            expressionData = expressionData.concat("0");
        }

        return expressionData.concat(value);
    }
}
