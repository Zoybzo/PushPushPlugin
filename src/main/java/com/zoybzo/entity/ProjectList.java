package com.zoybzo.entity;

import com.zoybzo.utils.ConstUtil;

import java.util.ArrayList;
import java.util.List;

public class ProjectList {
    private List<ProjectEntity> projectEntityList;

    public ProjectList() {
        this.projectEntityList = new ArrayList<>();
    }

    public int findByName(String projectName) {
        for (int i = 0; i < projectEntityList.size(); i++) {
            if (projectEntityList.get(i).getProjectName().equals(projectName)) {
                return i;
            }
        }
        return -1;
    }

    public void addProjectEntity(String projectName) {
        ProjectEntity projectEntity = new ProjectEntity(projectName);
        this.projectEntityList.add(projectEntity);
    }

    public ProjectEntity getProjectEntityByName(String projectName) {
        int index = findByName(projectName);
        if (index == ConstUtil.NOT_EXIST) return null;
        return projectEntityList.get(index);
    }

    public ProjectEntity getProjectEntityByIndex(int index) {
        return projectEntityList.get(index);
    }
}
