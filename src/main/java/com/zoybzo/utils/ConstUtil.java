package com.zoybzo.utils;

import java.io.File;

public class ConstUtil {
    public static final String FILE_PATH = "src/main/resources/pushData/";
    public static final String PROJECT_INFO = FILE_PATH.concat("projectInfo.json");
    public static final String USER_INFO = FILE_PATH.concat("userinfo.json");

    public static final Integer NOT_EXIST = -1;

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final Long DAY_MS = (long) (24 * 60 * 60 * 1000);
}
