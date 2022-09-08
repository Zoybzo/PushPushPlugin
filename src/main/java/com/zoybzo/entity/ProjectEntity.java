package com.zoybzo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {
    private String projectName; // 项目名称
    private Integer duration; // 打卡间隔时间
}
