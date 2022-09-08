package com.zoybzo.utils;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.NotNull;

public class ResponseUtil {
    // 在同一周期内多次签到
    public static void responsePushTooFrequency(GroupMessageEvent event) {
        event.getGroup().sendMessage(new PlainText("だが断る！时机还未成熟！").plus(new At(event.getSender().getId()).contentToString()));
//        (SingleMessage) () -> "だが断る！时机还未成熟！" + )
    }

    public static void responsePushSucceed(GroupMessageEvent event, String s) {
        event.getGroup().sendMessage(new PlainText(s + "Mission Succeed! 太棒了！现在可以卷别的打卡辣！").plus(new At(event.getSender().getId()).contentToString()));
//        s + "Mission Succeed! 太棒了！现在可以卷别的打卡辣！" + new At(event.getSender().getId())
    }
}
