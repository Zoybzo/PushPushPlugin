package com.zoybzo;

import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class ActiveCommand extends SimpleListenerHost {
    private String[] cmd;

    @EventHandler
    private ListeningStatus groupEvent(GroupMessageEvent event) {
        ListeningStatus status = ListeningStatus.LISTENING;
        String s = event.getMessage().contentToString();
        // judge cmd
        if (!s.startsWith("%")) return status;
        // split
        cmd = s.substring(1).split(" ");
        switch (cmd[0]) {
            case "push": { // 打卡
                pushCmd();
                break;
            }
            case "排行": { // 排行信息
                getRank();
                break;
            }
            case "玛丽苏": { // 设置提醒打卡周期
                setPushDuration();
                break;
            }
            case "打卡周期": {
                setPushIntervene();
                break;
            }
            case "卷": { // 加入某个打卡
                joinPush();
                break;
            }
            case "倒了": { // 退出某个打卡
                quitPush();
                break;
            }
            case "爱你孤身走暗巷": { // 随机歌曲 改一下弄音乐的那个
                break;
            }
            case "寄喽": {  // 奇怪的图片
                break;
            }
            case "rm": {  // 删除某个项目
                removePush();
                break;
            }
            case "help": { // 帮助
                getHelpInfo();
                break;
            }
            default: {
                break;
            }
        }
        return status;
    }

    private void pushCmd() {

    }

    // 需要权限
    private void removePush() {

    }

    private void joinPush() {

    }

    private void quitPush() {
    }

    private void getHelpInfo() {
    }

    private void getRank() {
    }

    private void setPushDuration() {

    }

    private void setPushIntervene() {

    }
}
