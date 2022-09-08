package com.zoybzo;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;


// %排名
// %
// %打卡
public class Command extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus groupEvent(GroupMessageEvent event) {
        ListeningStatus status = ListeningStatus.LISTENING;
        String s = event.getMessage().contentToString();
        // judge cmd
        if (!s.startsWith("%")) return status;
        // split
        String[] split = s.substring(1).split(" ");
        switch (split[0]) {
            case "push": { // 打卡
                break;
            }
            case "排行": { // 排行信息
                break;
            }
            case "玛丽苏": { // 设置提醒打卡周期
                break;
            }
            case "卷": { // 加入某个打卡
                break;
            }
            case "倒了": { // 退出某个打卡
                break;
            }
            case "爱你孤身走暗巷": { // 随机歌曲 改一下弄音乐的那个库
                break;
            }
            case "寄喽": {  // 奇怪的图片
                break;
            }
            case "rm": {  // 删除某个项目
                break;
            }
            case "help": { // 帮助
                break;
            }
            default: {
                break;
            }
        }
        return status;
    }

    @EventHandler
    private ListeningStatus pushEvent() {
        // TODO 怎么定时？
        ListeningStatus status = ListeningStatus.LISTENING;
        return status;
    }
}
