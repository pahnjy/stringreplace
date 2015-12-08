package com.pineone.code.study;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pahnj on 2015-12-06.
 */
@RestController
public class StringReplaceController {


    @Autowired
    IStringReplace stringReplace;

    @RequestMapping(value = "/stringreplace", method = RequestMethod.POST)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String dataProtocalController(@RequestBody InputData inputdata) {
        return stringReplace.replaceString(inputdata.getValue(),inputdata.getBefore(),inputdata.getAfter());
    }


}
