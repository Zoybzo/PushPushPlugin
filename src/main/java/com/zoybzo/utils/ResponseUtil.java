package com.zoybzo.utils;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.NotNull;

public class ResponseUtil {
    // 在同一周期内多次签到
    public static void responsePushTooFrequency(GroupMessageEvent event, String s) {
        event.getGroup().sendMessage(new PlainText(s + "这个任务已经完成啦！试试别的打卡吧~").plus(new At(event.getSender().getId()).contentToString()));
    }

    public static void responsePushSucceed(GroupMessageEvent event, String s) {
        event.getGroup().sendMessage(new PlainText(s + "Mission Succeed! 太棒了！现在可以卷别的打卡辣！").plus(new At(event.getSender().getId()).contentToString()));
    }
}
