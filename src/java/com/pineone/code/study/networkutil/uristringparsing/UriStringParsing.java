package com.pineone.code.study.networkutil.uristringparsing;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by pahnj on 2015-12-08.
 * key-value string 파싱 하는 API
 *
 */
@Service
public class UriStringParsing implements IUriStringParsing {


    public static final String DIVISION = "?";
    public static final int NOT_INDEX = -1;
    public static final String DIVISION_SENTENCE = "&";
    public static final int BEGIN_INDEX = 0;
    public static final String DIVISION_KEY = "=";

    public HashMap<String,String> urimap = new HashMap<String,String>();

    @Override
    public HashMap<String, String> getUrlParsing(String uri) {

        String orgString = "";
        String changeString = "";
        String inputKey = "";
        String inputValue = "";

        if(uri == null || uri.indexOf(DIVISION) == NOT_INDEX){
            return null;
        } else {
            orgString = uri.substring(uri.indexOf(DIVISION) + 1);

            while (orgString.indexOf(DIVISION_SENTENCE) != -1){
                UriService(orgString);
                orgString = orgString.substring(orgString.indexOf(DIVISION_SENTENCE) + 1);
            }
            if(orgString.indexOf(DIVISION_KEY) != -1){
                UriService( orgString);
            }
        }

        return urimap;
    }

    private void UriService(String orgString) {
        String changeString;
        String inputKey;
        String inputValue;
        if(orgString.indexOf(DIVISION_SENTENCE) == NOT_INDEX){
            changeString = orgString;
        } else {
            changeString = orgString.substring(BEGIN_INDEX, orgString.indexOf(DIVISION_SENTENCE));
        }
        inputKey = changeString.substring(BEGIN_INDEX, changeString.indexOf(DIVISION_KEY));
        inputValue = changeString.substring(changeString.indexOf(DIVISION_KEY)+1);
        urimap.put(inputKey,inputValue);
    }

    public String dataParsing(Object o)
    {
        ObjectMapper mapper = new ObjectMapper();
        String data = null;
        if(o == null){
            return data;
        }
        try
        {
            data = mapper.writeValueAsString(o);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
