package me.eripe.trees.utils;

import lombok.Getter;
import me.eripe.trees.bundle.BundleStorage;
import org.bukkit.TreeType;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeUtil {

    @Getter private static Set<Tree> TREES = new HashSet<>();

    public static void load(){
        FileConfiguration config = BundleStorage.getYaml("config.yml").getConfig();
        loadTrees(config, "oak", TreeType.TREE);
        loadTrees(config, "big_oak", TreeType.BIG_TREE);
        loadTrees(config, "swamp", TreeType.SWAMP);
        loadTrees(config, "dark_oak", TreeType.DARK_OAK);
        loadTrees(config, "acacia", TreeType.ACACIA);
        loadTrees(config, "birch", TreeType.BIRCH);
        loadTrees(config, "tall_birch", TreeType.TALL_BIRCH);
        loadTrees(config, "spruce", TreeType.REDWOOD);
        loadTrees(config, "mega_spruce", TreeType.MEGA_REDWOOD);
        loadTrees(config, "tall_spruce", TreeType.TALL_REDWOOD);
        loadTrees(config, "jungle", TreeType.JUNGLE);
        loadTrees(config, "jungle_bush", TreeType.JUNGLE_BUSH);
        loadTrees(config, "small_jungle", TreeType.SMALL_JUNGLE);
        loadTrees(config, "cocoa_tree", TreeType.COCOA_TREE);
        loadTrees(config, "brown_mushroom", TreeType.BROWN_MUSHROOM);
        loadTrees(config, "red_mushroom", TreeType.RED_MUSHROOM);
        loadTrees(config, "chorus_plant", TreeType.CHORUS_PLANT);
        loadTrees(config, "crimson_fungus", TreeType.CRIMSON_FUNGUS);
        loadTrees(config, "warped_fungus", TreeType.WARPED_FUNGUS);
    }

    private static void loadTrees(FileConfiguration config, String name, TreeType treeType){
        List<String> list = config.getStringList("trees." + name);
        if(list == null) return;
        if(list.isEmpty()) return;
        for(String tree : list){
            getTREES().add(new Tree(tree, treeType));
        }
    }

    public static List<Tree> getTrees(TreeType treeType){
        List<Tree> trees = new ArrayList<>();
        for(Tree tree : getTREES()){
            if(tree.getTreeType().equals(treeType)){
                trees.add(tree);
            }
        }
        return trees;
    }

    public static String randomTree(TreeType treeType){
        List<Tree> trees = getTrees(treeType);
        if(trees == null) return null;
        if(trees.isEmpty()) return null;
        if(trees.size() == 1){
            return trees.get(0).getName();
        }
        return trees.get(RandomUtil.getRandInt(0, (trees.size() - 1))).getName();
    }
}
