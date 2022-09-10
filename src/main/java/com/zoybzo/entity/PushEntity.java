package com.zoybzo.entity;


import java.text.SimpleDateFormat;

public class PushEntity {
    private String id; // 用户ID QQ
    private ProjectEntity project; // 对应的项目
    private Integer currentDuration; // 当前连续打卡次数
    private Integer longestDuration; // 最长持续打卡次数
    private String lastPushTime; // 上一次打卡的时间
    private Integer pushTime; // Unit: hour 隔多久push一次

    public PushEntity() {
    }

    public PushEntity(String id, ProjectEntity project, Integer currentDuration, Integer longestDuration, String lastPushTime, Integer pushTime) {
        this.id = id;
        this.project = project;
        this.currentDuration = currentDuration;
        this.longestDuration = longestDuration;
        this.lastPushTime = lastPushTime;
        this.pushTime = pushTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public Integer getCurrentDuration() {
        return currentDuration;
    }

    public void setCurrentDuration(Integer currentDuration) {
        this.currentDuration = currentDuration;
    }

    public Integer getLongestDuration() {
        return longestDuration;
    }

    public void setLongestDuration(Integer longestDuration) {
        this.longestDuration = longestDuration;
    }

    public String getLastPushTime() {
        return lastPushTime;
    }

    public void setLastPushTime(String lastPushTime) {
        this.lastPushTime = lastPushTime;
    }

    public Integer getPushTime() {
        return pushTime;
    }

    public void setPushTime(Integer pushTime) {
        this.pushTime = pushTime;
    }

    @Override
    public String toString() {
        return "PushEntity{" +
                "id='" + id + '\'' +
                ", project=" + project +
                ", currentDuration=" + currentDuration +
                ", longestDuration=" + longestDuration +
                ", lastPushTime='" + lastPushTime + '\'' +
                ", pushTime=" + pushTime +
                '}';
    }

    public String toString2User() {
        return "🤞你的ID='" + id + '\'' +
                "\n❤打卡任务=" + project.getProjectName() +
                "\n💖打卡刷新周期=" + project.getDuration() +
                "\n👌当前连续打卡次数=" + currentDuration +
                "\n✌最长连续打卡次数=" + longestDuration +
                "\n🌹上次打卡时间='" + lastPushTime + '\'' +
                "\n✔打卡提醒周期=" + pushTime +
                "\n";
    }
}
