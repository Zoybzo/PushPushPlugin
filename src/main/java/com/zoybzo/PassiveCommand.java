package com.zoybzo;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;

public class PassiveCommand extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus pushEvent() {
        // TODO 怎么定时？
        ListeningStatus status = ListeningStatus.LISTENING;
        return status;
    }
}
