package io.github.strendey.damageindicators.listener;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class NameFormatListener {

    public static boolean enable = true;

    @SubscribeEvent
    public void onNameFormatEvent(PlayerEvent.NameFormat event) {
        if (!enable)
            return;
        EntityPlayer player = event.entityPlayer;
        EntityClientPlayerMP clientPlayer = Minecraft.getMinecraft().thePlayer;
        if (player == null || clientPlayer == null)
            return;
        if (player.getCommandSenderName().equals(clientPlayer.getCommandSenderName()))
            return;

        double health = Math.round(player.getHealth()) / 2d;

        EnumChatFormatting color = EnumChatFormatting.GREEN;
        if (health <= 2.5)
            color = EnumChatFormatting.DARK_RED;
        else if (health <= 4.5)
            color = EnumChatFormatting.RED;
        else if (health <= 7.0)
            color = EnumChatFormatting.GOLD;

        if (health % 1 == 0)
            event.displayname = event.username + " " + color + (int) health;
        else
            event.displayname = event.username + " " + color + health;
    }

}
