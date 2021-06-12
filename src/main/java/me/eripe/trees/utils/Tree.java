package me.eripe.trees.utils;

import lombok.Data;
import org.bukkit.TreeType;

public @Data
class Tree {

    private String name;
    private TreeType treeType;

    public Tree(String name, TreeType treeType){
        this.name = name;
        this.treeType = treeType;
    }
}
