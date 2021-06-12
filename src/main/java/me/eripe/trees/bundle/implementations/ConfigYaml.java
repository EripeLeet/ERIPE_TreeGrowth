package me.eripe.trees.bundle.implementations;

import me.eripe.trees.bundle.Yaml;
import org.bukkit.plugin.Plugin;

public class ConfigYaml extends Yaml {
    public ConfigYaml(Plugin plugin) {
        super(plugin, "config.yml");
    }
}
