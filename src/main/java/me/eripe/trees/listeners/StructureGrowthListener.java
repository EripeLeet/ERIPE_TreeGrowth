package me.eripe.trees.listeners;

import me.eripe.trees.utils.SchemUtil;
import me.eripe.trees.utils.TreeUtil;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

public class StructureGrowthListener implements Listener {

    @EventHandler
    public void onGrow(StructureGrowEvent event){
        if(event.getSpecies() == null) return;
        TreeType treeType = event.getSpecies();
        String tree = TreeUtil.randomTree(treeType);
        if(tree == null) return;
        event.setCancelled(true);
        SchemUtil.placeTree(tree, event.getLocation());
    }
}
