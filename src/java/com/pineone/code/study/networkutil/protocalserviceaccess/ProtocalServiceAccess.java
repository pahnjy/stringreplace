package com.pineone.code.study.networkutil.protocalserviceaccess;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by pahnj on 2015-12-20.
 */
@Service
public class ProtocalServiceAccess implements IProtocalServiceAccess {

    @Override
    public String getHtmlData(String data) {
        String result = null;
        StringBuffer sb = new StringBuffer();

        try {
            URL url = new URL(data);
            URLConnection uc = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                sb.append(inputLine);
                System.out.println(inputLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = sb.toString();
        return result;
    }

    @Override
    public String getBinary(String data) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        try {

            URL obj = new URL(data);
            URLConnection uc = obj.openConnection();
            Map<String, List<String>> map = uc.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String inputData = "Key : " + entry.getKey() + " ,Value : " + entry.getValue();
                sb.append(inputData);
                System.out.println(inputData);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                sb.append(inputLine);
                System.out.println(inputLine);
            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        result = sb.toString();
        return result;

    }

}
