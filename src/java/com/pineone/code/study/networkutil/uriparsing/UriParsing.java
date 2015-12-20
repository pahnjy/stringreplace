package com.pineone.code.study.networkutil.uriparsing;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-06.
 * URL parser
 * 해당 url을 분석하여 파싱하는 API제공
 */

@Service
public class UriParsing implements IUriParsingApi {


    public static final String PRPTOCAL_DIVIDER = "://";
    public static final String PROTOCAL_PREPIX = ":";
    public static final String URL_DIVIDER = "/";

    public String getProtocal(String url) {
        if (url == null || url.length() == 0) {
            return "no data";
        } else {
            return url.substring(0, url.indexOf(PROTOCAL_PREPIX));
        }
    }

    public String getHost(String url) {
        if (url == null || url.length() == 0) {
            return "no data";
        }

        int prefixData = 3;

        if(url.indexOf(PRPTOCAL_DIVIDER) != -1){
            prefixData = 3;
        } else if(url.indexOf(PROTOCAL_PREPIX) != -1){
            prefixData = 1;
        }

        String host = url.substring(url.indexOf(PROTOCAL_PREPIX) + prefixData, url.length());

        if (host.indexOf(PROTOCAL_PREPIX) != -1) {
            return host.substring(0, host.indexOf(PROTOCAL_PREPIX));
        } else if (host.indexOf(URL_DIVIDER) != -1) {
            return host.substring(0, host.indexOf(URL_DIVIDER));
        } else {
            return host;
        }

    }

    public String getPort(String url) {

        String port = url.substring(url.indexOf(PROTOCAL_PREPIX) + 3, url.length());

        if (port.indexOf(PROTOCAL_PREPIX) == -1) {
            return "8080";
        } else if (port.indexOf(URL_DIVIDER) != -1) {
            return port.substring(port.indexOf(PROTOCAL_PREPIX) + 1, port.indexOf(URL_DIVIDER));
        } else {
            return port.substring(port.indexOf(PROTOCAL_PREPIX) + 1, port.length());
        }

    }

    public String getSub(String url) {

        String sub = "";

        if (url == null || url.length() == 0) {
            return "no data";
        }


        int startSubindex = getProtocal(url).length() + getHost(url).length() + 1;
        sub = url.substring(startSubindex, url.length());

        if (sub.indexOf(URL_DIVIDER) == -1) {
            return "no sub data";
        }

        startSubindex = sub.indexOf(URL_DIVIDER);
        sub = sub.substring(startSubindex + 1, sub.length());
        if(sub.length() == 0){
            return "no sub data";
        }
        return sub;
    }
}
