package com.zoybzo.cmd;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.regex.Pattern;

public class test extends SimpleListenerHost {
    public static int n = 5;

    @EventHandler
    private ListeningStatus onEvent(GroupMessageEvent event) {
        String s = event.getMessage().contentToString();
//        String pattern = "(.*)寄(.*)";
        String pattern = "不参加";
        if (Pattern.matches(pattern, s)) {
            String id = String.valueOf(event.getSender().getId());
            if (String.valueOf(event.getSender().getId()).equals("2561914955")) n += 1;
            event.getGroup().sendMessage("不参加*" + String.valueOf(n));
        }
        return ListeningStatus.LISTENING;
    }
}
