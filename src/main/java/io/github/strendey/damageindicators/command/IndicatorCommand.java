package io.github.strendey.damageindicators.command;

import io.github.strendey.damageindicators.listener.NameFormatListener;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Collections;
import java.util.List;

public class IndicatorCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "strendeyindicators";
    }

    @Override
    public List getCommandAliases() {
        return Collections.singletonList("si");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return EnumChatFormatting.RED + "Uso: /strendeyindicators <on | off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.addChatMessage(new ChatComponentText(getCommandUsage(null)));
            return;
        }

        if (args[0].equalsIgnoreCase("on")) {
            NameFormatListener.enable = true;
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "StrendeyIndicators ativado."));
        } else if (args[0].equalsIgnoreCase("off")) {
            NameFormatListener.enable = false;
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "StrendeyIndicators desativado."));
        } else
            sender.addChatMessage(new ChatComponentText(getCommandUsage(null)));
    }

}
