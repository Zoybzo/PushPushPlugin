package com.zoybzo;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;

public final class PushPush extends JavaPlugin {
    public static final PushPush INSTANCE = new PushPush();

    private PushPush() {
        super(new JvmPluginDescriptionBuilder("com.zoybzo.push", "0.1.0")
                .name("PushPush")
                .author("Zoybzo")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
        GlobalEventChannel.INSTANCE.registerListenerHost(new test());
    }
}