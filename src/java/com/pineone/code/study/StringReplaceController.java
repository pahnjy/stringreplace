package com.pineone.code.study;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by pahnj on 2015-12-06.
 */
@RestController
public class StringReplaceController {


    @Autowired
    IStringReplace stringReplace;

    @Autowired
    IUriStringParsing uriStringParsing;

    @RequestMapping(value = "/stringreplace", method = RequestMethod.POST)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String dataProtocalController(@RequestBody InputData inputdata) {
        return stringReplace.replaceString(inputdata.getValue(),inputdata.getBefore(),inputdata.getAfter());
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public HashMap<String, String> urlDataParsingController(@RequestBody String uri){

        return uriStringParsing.getUrlParsing(uri);
    }

}
