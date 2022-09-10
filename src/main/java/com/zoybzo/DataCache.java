package com.zoybzo;

import com.zoybzo.entity.ProjectEntity;
import com.zoybzo.entity.ProjectList;
import com.zoybzo.entity.PushEntity;
import com.zoybzo.entity.PushList;
import com.zoybzo.utils.ConstUtil;
import com.zoybzo.utils.JsonUtil;
import kotlinx.serialization.json.Json;

import javax.xml.crypto.Data;

/*
 * Just for lock.
 */
public class DataCache {
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

    public boolean save() {
        JsonUtil.object2JsonFile(ConstUtil.USER_INFO, dataCache.getPushList());
        JsonUtil.object2JsonFile(ConstUtil.PROJECT_INFO, dataCache.getProjectList());
        return true;
    }
}
