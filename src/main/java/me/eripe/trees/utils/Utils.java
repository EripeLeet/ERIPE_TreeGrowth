package me.eripe.trees.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String color(String text) {
        if(text == null) return "";
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static boolean sendMessage(CommandSender sender, String message){
        if(sender == null || message == null || message.isEmpty()) return false;
        sender.sendMessage(fixColor(message));
        return true;
    }
}
