package com.data_stream.proximitytextchat;

import com.data_stream.proximitytextchat.config.ProxTextConfig;
import com.data_stream.proximitytextchat.events.AllowChatHandler;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.config.ModConfig;


public class Main implements ModInitializer {

    public static final String MODID = "proximitytextchat";

    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.COMMON, ProxTextConfig.SPEC, "proximitytextchat-common.toml");
        ServerMessageEvents.ALLOW_CHAT_MESSAGE.register(new AllowChatHandler());
    }
}

