package com.zoybzo;

import com.zoybzo.entity.ProjectEntity;
import com.zoybzo.entity.ProjectList;
import com.zoybzo.entity.PushList;
import com.zoybzo.utils.ConstUtil;
import com.zoybzo.utils.JsonUtil;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;

public final class PushPush extends JavaPlugin {
    public static final PushPush INSTANCE = new PushPush();

    private ProjectList projectList;
    private PushList pushList;

    private PushPush() {
        super(new JvmPluginDescriptionBuilder("com.zoybzo.push", "0.1.0")
                .name("PushPush")
                .author("Zoybzo")
                .build());
        // init
        DataCache.getInstance(); // 初始实例化一下
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
        GlobalEventChannel.INSTANCE.registerListenerHost(new test());
        GlobalEventChannel.INSTANCE.registerListenerHost(new ActiveCommand());
    }
}