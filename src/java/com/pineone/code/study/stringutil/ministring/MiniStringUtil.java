package com.pineone.code.study.stringutil.ministring;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-06.
 * 자리수 맞추기
 * 입력된 정수를 포함하여 입력된 전체 자리수를 표현한 문자열을 리턴하시오. 입력된 정수를 제외한 문자는 '0'(영)으로 채웁니다.
 * ex)12를 4자리로 표현하기 --> 0012
 *    350을 8자리로 표현하기 --> 00000350
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
