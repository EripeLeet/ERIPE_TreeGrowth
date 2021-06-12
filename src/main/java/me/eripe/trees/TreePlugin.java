package me.eripe.trees;

import lombok.Getter;
import me.eripe.trees.bundle.BundleStorage;
import me.eripe.trees.bundle.implementations.ConfigYaml;
import me.eripe.trees.commands.CommandManager;
import me.eripe.trees.commands.implementations.TreeGtowthCommand;
import me.eripe.trees.listeners.StructureGrowthListener;
import me.eripe.trees.utils.TreeUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TreePlugin extends JavaPlugin {

    @Getter private static TreePlugin treePlugin;

    @Override
    public void onEnable() {
        treePlugin = this;
        (new BundleStorage()).registerYamls(new ConfigYaml(this));
        initTree();
        (new CommandManager()).registerCommands(new TreeGtowthCommand());
        TreeUtil.load();
        Bukkit.getPluginManager().registerEvents(new StructureGrowthListener(), this);

    }

    private void initTree(){
        File file = new File(getDataFolder() + File.separator + "trees");
        if(!file.exists()){
            file.mkdir();
        }
        saveTree("default1.schem");
        saveTree("default2.schem");
        saveTree("default3.schem");
    }

    private void saveTree(String name){
        File f1 = new File(getDataFolder() + File.separator + "trees", name);
        if(!f1.exists()){
            saveResource(name, true);
            f1 = new File(getDataFolder(), name);
        }
        File f2 = new File(getDataFolder() + File.separator + "trees", name);
        f1.renameTo(f2);
    }

}
