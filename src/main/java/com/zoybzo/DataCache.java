package com.zoybzo;

import com.zoybzo.entity.ProjectEntity;
import com.zoybzo.entity.ProjectList;
import com.zoybzo.entity.PushEntity;
import com.zoybzo.entity.PushList;
import com.zoybzo.utils.ConstUtil;
import com.zoybzo.utils.JsonUtil;

import javax.xml.crypto.Data;

/*
 * Just for lock.
 */
public class DataCache {
//    private static DataCache dataCache;
//    private ProjectList projectList;
//    private PushList pushList;
//
//    private DataCache() {
//        projectList = JsonUtil.jsonFile2Object(ConstUtil.PROJECT_INFO, ProjectList.class);
//        pushList = JsonUtil.jsonFile2Object(ConstUtil.USER_INFO, PushList.class);
//        if (projectList == null) projectList = new ProjectList();
//        if (pushList == null) pushList = new PushList();
//    }
//
//    public static DataCache getInstance() {
//        if (dataCache == null) dataCache = new DataCache();
//        return dataCache;
//    }

    private volatile static DataCache dataCache;
    private ProjectList projectList;
    private PushList pushList;

    private DataCache() {
        // init
        projectList = JsonUtil.jsonFile2Object(ConstUtil.PROJECT_INFO, ProjectList.class);
        pushList = JsonUtil.jsonFile2Object(ConstUtil.USER_INFO, PushList.class);
        if (projectList == null) projectList = new ProjectList();
        if (pushList == null) pushList = new PushList();
    }

    public static DataCache getInstance() {
        if (dataCache == null) {
            synchronized (DataCache.class) {
                if (dataCache == null) {
                    dataCache = new DataCache();
                }
            }
        }
        return dataCache;
    }

    public ProjectList getProjectList() {
        return projectList;
    }

    public PushList getPushList() {
        return pushList;
    }
}
