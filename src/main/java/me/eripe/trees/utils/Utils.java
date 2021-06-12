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

    public static List<String> color(List<String> list){
        if(list == null || list.isEmpty()) return new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            list.set(i, color(list.get(i)));
        }
        return list;
    }

    public static boolean sendMessage(CommandSender sender, String message){
        if(sender == null || message == null || message.isEmpty()) return false;
        sender.sendMessage(fixColor(message));
        return true;
    }
}
