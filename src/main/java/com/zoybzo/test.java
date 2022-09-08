package com.zoybzo;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public class test extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus onEvent(FriendMessageEvent event) {
        String s = event.getMessage().contentToString();
        if (s.equals("hi")) {
            event.getSender().sendMessage("Hello");
        }
        return ListeningStatus.LISTENING;
    }
}
