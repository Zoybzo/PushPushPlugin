package com.zoybzo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushEntity {
    private String id; // 用户ID QQ
    private ProjectEntity project; // 对应的项目
    private Integer currentDuration; // 当前连续打卡次数
    private Integer LongestDuration; // 最长持续打卡次数
    private Date lastPushTime; // 上一次打卡的时间
    private Integer pushTime; // Unit: hour 隔多久push一次

}
