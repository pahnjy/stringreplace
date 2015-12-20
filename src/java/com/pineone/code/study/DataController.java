package com.pineone.code.study;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pineone.code.study.networkutil.nslookup.INsLookUp;
import com.pineone.code.study.networkutil.protocalserviceaccess.IProtocalServiceAccess;
import com.pineone.code.study.networkutil.uriparsing.IUriParsingApi;
import com.pineone.code.study.networkutil.uristringparsing.IUriStringParsing;
import com.pineone.code.study.stringutil.checkversion.ICheckTheVersion;
import com.pineone.code.study.stringutil.dataformatter.IDateFormatter;
import com.pineone.code.study.stringutil.hextointstring.IHexToIntStringParsing;
import com.pineone.code.study.stringutil.inttohex.IIntToHexParsing;
import com.pineone.code.study.stringutil.ministring.IMiniStringUtil;
import com.pineone.code.study.stringutil.stringreplace.IStringReplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by pahnj on 2015-12-06.
 */
@RestController
public class DataController {


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

    @Autowired
    INsLookUp nsLookUp;

    @Autowired
    IUriParsingApi uriParsingApi;

    @Autowired
    IMiniStringUtil miniStringUtil;

    @RequestMapping(value = "/stringutil/{value}", method = RequestMethod.POST)
    public String miniStringController(@RequestBody String length,@PathVariable String value) {
        return miniStringUtil.changeExpression(value, length);
    }

    @RequestMapping(value = "/protocol", method = RequestMethod.POST)
    public String dataProtocalController(@RequestBody String url) {
        return uriParsingApi.getProtocal(url);
    }

    @RequestMapping(value = "/host", method = RequestMethod.POST)
    public String dataHostController(@RequestBody String url) {
        return uriParsingApi.getHost(url);
    }

    @RequestMapping(value = "/port", method = RequestMethod.POST)
    public String dataPortController(@RequestBody String url) {
        return uriParsingApi.getPort(url);
    }

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public String dataSubController(@RequestBody String url) {
        return uriParsingApi.getSub(url);
    }

    @RequestMapping(value = "/nslookup", method = RequestMethod.POST)
    public String nslookupController(@RequestBody String address) {

        return nsLookUp.getAddress(address);
    }

    @RequestMapping(value = "/stringreplace", method = RequestMethod.POST)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String stringReplaceController(@RequestBody InputData inputdata) {
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

        if(REQUEST_HEADER.equals(type))
        {
            return protocalServiceAccess.getBinary(url);
        } else if(REQUEST_HTMLDATA.equals(type))
        {
            return protocalServiceAccess.getHtmlData(url);
        }
        return protocalServiceAccess.getHtmlData(url);
    }

}
