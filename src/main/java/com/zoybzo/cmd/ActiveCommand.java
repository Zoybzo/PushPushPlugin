package com.zoybzo.cmd;

import com.zoybzo.DataCache;
import com.zoybzo.entity.ProjectEntity;
import com.zoybzo.entity.ProjectList;
import com.zoybzo.entity.PushEntity;
import com.zoybzo.entity.PushList;
import com.zoybzo.utils.ConstUtil;
import io.ktor.client.features.Sender;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class ActiveCommand extends SimpleListenerHost {
    private String[] cmd;
    private GroupMessageEvent event;

    @EventHandler
    private ListeningStatus groupEvent(GroupMessageEvent event) {
        System.out.println(event.toString());
        ListeningStatus status = ListeningStatus.LISTENING;
        String s = event.getMessage().contentToString();
        this.event = event;
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
            case "save": { // 存储文件
                saveJson();
                break;
            }
            default: {
                break;
            }
        }
        return ListeningStatus.LISTENING;
    }

    private boolean saveJson() {
        return DataCache.getInstance().save();
    }

    private boolean pushCmd() {
        // %push <project name>
        // 让这个用户在这个项目上打卡 需要判断一下这个用户当前的打卡时间与它上一次的打卡时间的间隔是否大于该项目的打卡间隔
        // 如果这个项目不存在 则创建一个这个项目
        if (cmd.length < 2) return false;
        String projectName = cmd[1];
        // projectList
        int index = DataCache.getInstance().getProjectList().findByName(projectName);
        // new Project
        if (index == ConstUtil.NOT_EXIST) {
            DataCache.getInstance().getProjectList().addProjectEntity(projectName);
        }
        //  update
        return DataCache.getInstance().getPushList().pushNow(event, projectName);
    }


    // 需要权限
    private void removePush() {
        // %rm <project name>
        // 判断这个项目是否存在
        // 判断这个用户的权限是否足够（需要看权限部分的代码 建议留给我）
    }

    @Deprecated
    private void joinPush() {
        // %我要卷 <project name>
        // 加入到某个打卡中
        // 不要了
    }

    private void quitPush() {
        // %倒了 <project name>

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
