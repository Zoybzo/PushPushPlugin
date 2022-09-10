package com.zoybzo.entity;

import com.zoybzo.DataCache;
import com.zoybzo.utils.ConstUtil;
import com.zoybzo.utils.ResponseUtil;
import kotlinx.serialization.StringFormat;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PushList {
    private List<PushEntity> pushEntityList;

    public PushList() {
        this.pushEntityList = new ArrayList<>();
    }

    public List<PushEntity> getPushEntityList() {
        return pushEntityList;
    }

    public void setPushEntityList(List<PushEntity> pushEntityList) {
        this.pushEntityList = pushEntityList;
    }

    public boolean pushNow(GroupMessageEvent event, String projectName) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstUtil.DATE_PATTERN);
        int index = DataCache.getInstance().getPushList().findByName(String.valueOf(event.getSender().getId()), projectName);
        if (index == ConstUtil.NOT_EXIST) {
            PushEntity pushEntity = new PushEntity(
                    String.valueOf(event.getSender().getId()),
                    new ProjectEntity(projectName),
                    ConstUtil.DEFAULT_CURRENT_DURATION,
                    ConstUtil.DEFAULT_LONGEST_DURATION,
                    simpleDateFormat.format(nowDate),
                    ConstUtil.DEFAULT_PUSH_TIME
            );
            pushEntityList.add(pushEntity);
            ResponseUtil.responsePushSucceed(event, pushEntity.toString2User());
        } else {
            // check duration
            PushEntity it = this.pushEntityList.get(index);
            try {
                long lastPushTime = simpleDateFormat.parse(it.getLastPushTime()).getTime();
                long currentPushTime = nowDate.getTime();
                long diff = (currentPushTime - lastPushTime); // ms
                if (diff <= ConstUtil.DAY_MS) {
                    ResponseUtil.responsePushTooFrequency(event, it.toString2User());
                    return false;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            //
            it.setLastPushTime(simpleDateFormat.format(nowDate));
            it.setCurrentDuration(it.getCurrentDuration() + 1);
            if (it.getCurrentDuration() > it.getLongestDuration()) {
                it.setLongestDuration(it.getCurrentDuration());
            }
            ResponseUtil.responsePushSucceed(event, it.toString2User());
        }
        return true;
    }

    private int findByName(String id, String projectName) {
        for (int i = ConstUtil.LOOP_BEGIN; i < this.pushEntityList.size(); i++) {
            PushEntity it = pushEntityList.get(i);
            if (it != null && it.getId().equals(String.valueOf(id)) && it.getProject().getProjectName().equals(projectName)) {
                // check duration
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "PushList{" +
                "pushEntityList=" + pushEntityList +
                '}';
    }
}
