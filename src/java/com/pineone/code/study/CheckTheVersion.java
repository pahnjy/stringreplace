package com.pineone.code.study;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-20.
 */
@Service
public class CheckTheVersion implements ICheckTheVersion {
    public static final int CHECK_LIMIT = 3;
    public static final int NOT_DIVIDE = -1;
    public static String SOFTWARE_VERSION = "1.0.0";
    public static final String SPLIT_DIVIDE = "\\.";
    public static final String CHECK_DIVIDE = ".";

    @Override
    public boolean checkVersion(String version) {

        if (version.indexOf(CHECK_DIVIDE) == NOT_DIVIDE) {
            return Boolean.FALSE;
        }

        String[] checkVersion = version.split(SPLIT_DIVIDE);
        String[] orgVersion = SOFTWARE_VERSION.split(SPLIT_DIVIDE);

        if (!isInvalid(checkVersion) || !isInvalid(orgVersion)) {
            return Boolean.FALSE;
        }


        int version_count = 0;
        while (CHECK_LIMIT > version_count) {
            if (isUpgrage(checkVersion[version_count], orgVersion[version_count])) {
                return Boolean.FALSE;
            }
            version_count++;
        }

        return Boolean.TRUE;

    }

    private boolean isInvalid(String[] version) {

        for (String data : version) {
            try {
                Integer.parseInt(data);
            } catch (NumberFormatException e) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    private boolean isUpgrage(String checkversion, String orgversion) {
        return Integer.parseInt(checkversion) < Integer.parseInt(orgversion);
    }


}
