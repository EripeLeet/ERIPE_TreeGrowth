package me.eripe.trees.commands.implementations;

import me.eripe.trees.bundle.BundleStorage;
import me.eripe.trees.commands.Command;
import me.eripe.trees.utils.TreeUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class TreeGtowthCommand extends Command {

    public TreeGtowthCommand() {
        super("treegrowth");
        makeUp("Reload plugin configuration file!", "/treegrowth reload", new String[0]);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, String[] args) {
        if(args.length == 0){
            commandSender.sendMessage(ChatColor.RED + "To reload the file, enter: /treegrowth reload");
            return false;
        }
        if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")){
            BundleStorage.getYaml("config.yml").reloadData();
            TreeUtil.getTREES().clear();
            TreeUtil.load();
            commandSender.sendMessage(ChatColor.GREEN + "The file and manager has been reloaded!");
            return true;
        }
        commandSender.sendMessage(ChatColor.RED + "To reload the file, enter: /treegrowth reload");
        return false;
    }
}
