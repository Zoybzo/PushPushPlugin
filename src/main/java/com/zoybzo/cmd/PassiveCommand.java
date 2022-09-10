package com.zoybzo.cmd;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;

public class PassiveCommand extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus pushEvent() {
        // TODO 怎么定时？
        // 需要做的事情：1.每天提醒群成员打卡
        ListeningStatus status = ListeningStatus.LISTENING;
        return status;
    }
}
