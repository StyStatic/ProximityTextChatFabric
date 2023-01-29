package com.data_stream.proximitytextchat.events;

import com.data_stream.proximitytextchat.config.ProxTextConfig;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.PlayerManager;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AllowChatHandler implements ServerMessageEvents.AllowChatMessage{
    @Override
    public boolean allowChatMessage(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
        final BlockPos playerPos = sender.getBlockPos();
        final List<ServerPlayerEntity> playerList = sender.getServer().getPlayerManager().getPlayerList();

        for (int i = 0; i < playerList.size(); i++) {
            final double distance = Math.sqrt(playerList.get(i).getBlockPos().getSquaredDistance(playerPos));
            if (distance <= ProxTextConfig.PROX_RANGE.get()) {
                playerList.get(i).sendMessage(Text.of("<" + sender.getName().getString() + "> " + message.getSignedContent()));
            }
            if (distance >= ProxTextConfig.PROX_RANGE.get() && distance <= ProxTextConfig.DIST_RANGE.get() && ProxTextConfig.TOGGLEDISTORTION.get()) {
                String[] words = message.getSignedContent().split("\\s+");
                String newmessage = "";
                Random rand = new Random();
                for (int j = 0; j < words.length; j++) {
                    int randomint = rand.nextInt(4);
                    if (randomint == 2) {
                        if (!ProxTextConfig.UNDERSCOREMODE.get()) {
                            words[j] = ProxTextConfig.WORD_REPLACEMENT.get();
                        } else {
                            String newString = "";
                            for (int e = 0; e  < words[j].length(); e++) {
                                newString = newString + "_";
                            }
                            words[j] = newString;
                        }
                    }
                    newmessage = newmessage + words[j] + " ";
                }
                playerList.get(i).sendMessage(Text.of("<" + sender.getName().getString() + "> " + newmessage));
            }
        }
        return false;
    }
}
