package com.zoybzo;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.regex.Pattern;

public class test extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus onEvent(GroupMessageEvent event) {
        String s = event.getMessage().contentToString();
        String pattern = "(.*)寄(.*)";
        if (Pattern.matches(pattern, s)) {
            String id = String.valueOf(event.getSender().getId());
            event.getGroup().sendMessage(id);
        }
        return ListeningStatus.LISTENING;
    }
}
