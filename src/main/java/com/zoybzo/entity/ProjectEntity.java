package com.zoybzo.entity;

public class ProjectEntity {
    private String projectName; // 项目名称
    private Integer duration; // 打卡间隔时间 Unit:hour

    public ProjectEntity() {
    }

    public ProjectEntity(String projectName, Integer duration) {
        this.projectName = projectName;
        this.duration = duration;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public ProjectEntity(String projectName) {
        this.projectName = projectName;
        this.duration = 24;
    }

}
