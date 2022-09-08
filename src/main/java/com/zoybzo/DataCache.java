package com.zoybzo;

import com.zoybzo.entity.ProjectEntity;
import com.zoybzo.entity.ProjectList;
import com.zoybzo.entity.PushEntity;
import com.zoybzo.entity.PushList;
import com.zoybzo.utils.ConstUtil;
import com.zoybzo.utils.JsonUtil;

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
}
