package com.pineone.code.study;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by pahnj on 2015-12-06.
 */
@RestController
public class DataController {


    public static final String REQUEST_BODY = "body";
    public static final String REQUEST_HEADER = "header";
    public static final String REQUEST_HTMLDATA = "htmldata";
    @Autowired
    IStringReplace stringReplace;

    @Autowired
    IUriStringParsing uriStringParsing;

    @Autowired
    IHexToIntStringParsing hexToIntStringParsing;

    @Autowired
    IIntToHexParsing intToHexParsing;

    @Autowired
    IDateFormatter dateFormatter;

    @Autowired
    ICheckTheVersion checkTheVersion;
    @Autowired
    IProtocalServiceAccess protocalServiceAccess;

    @RequestMapping(value = "/stringreplace", method = RequestMethod.POST)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String dataProtocalController(@RequestBody InputData inputdata) {
        return stringReplace.replaceString(inputdata.getValue(),inputdata.getBefore(),inputdata.getAfter());
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public HashMap<String, String> urlDataParsingController(@RequestBody String uri){

        return uriStringParsing.getUrlParsing(uri);
    }

    @RequestMapping(value = "/hextoint", method = RequestMethod.POST)
    public int hexToIntParsingController(@RequestBody String hex){
        return hexToIntStringParsing.HextoString(hex);
    }

    @RequestMapping(value = "/inttohex", method = RequestMethod.POST)
    public String IntToHexParsingController(@RequestBody String dec){
        return intToHexParsing.IntToHexString(Integer.parseInt(dec));
    }

    @RequestMapping(value = "/dateformatter", method = RequestMethod.POST)
    public String DateFormatterController(@RequestBody String places){

        return dateFormatter.getDate(Calendar.getInstance(), places);
    }

    /**
     *
     * @param version
     * @return upgrade check. true : 버전업 필요, false : 기존 버전이 높음
     */
    @RequestMapping(value = "/ckversion", method = RequestMethod.POST)
    public boolean VersionController(@RequestBody String version){

        return checkTheVersion.checkVersion(version);
    }

    @RequestMapping(value = "/serviceaccess/{type}", method = RequestMethod.POST)
    public String ServiceAcceccController(@RequestBody String url, @PathVariable String type){

        if(REQUEST_BODY.equals(type))
        {
            return protocalServiceAccess.getbody(url);
        } else if(REQUEST_HEADER.equals(type))
        {
            return protocalServiceAccess.getHeader(url);
        } else if(REQUEST_HTMLDATA.equals(type))
        {
            return protocalServiceAccess.getHtmlData(url);
        }
        return protocalServiceAccess.getHtmlData(url);
    }

}
