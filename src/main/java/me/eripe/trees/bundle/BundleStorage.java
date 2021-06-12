package me.eripe.trees.bundle;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BundleStorage {

    @Getter private static Map<String, Yaml> YAMLS = new HashMap<>();

    public BundleStorage(){
    }

    public void registerYaml(Yaml yaml){
        yaml.init();
        getYAMLS().put(yaml.getName().toLowerCase(), yaml);
    }

    public void registerYamls(Yaml... yamls){
        Arrays.asList(yamls).forEach(yaml -> {
            registerYaml(yaml);
        });
    }

    public static Yaml getYaml(String name){
        return getYAMLS().get(name.toLowerCase());
    }



}
