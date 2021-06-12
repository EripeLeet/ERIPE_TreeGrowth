package me.eripe.trees.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import me.eripe.trees.TreePlugin;
import org.bukkit.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SchemUtil {

    public static int rotation() {
        int[] rot = {
                10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
                290, 300, 310, 320, 330, 340, 350 };
        int i = RandomUtil.getRandInt(0, rot.length - 1);
        return i;
    }

    public static int random() {
        return RandomUtil.getRandInt(0, 2);
    }

    public static void placeTree(String name, Location location) {
        File file = new File(TreePlugin.getTreePlugin().getDataFolder().getAbsolutePath() + "/trees/" + name);
        ClipboardFormat format = ClipboardFormats.findByFile(file);
        ClipboardReader reader = null;
        Clipboard clipboard = null;
        try {
            reader = format.getReader(new FileInputStream(file));
            clipboard = reader.read();
            World adaptedWorld = BukkitAdapter.adapt(location.getWorld());
            EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld, -1);
            ClipboardHolder holder = new ClipboardHolder(clipboard);
            if (RandomUtil.getChance(80.0D)) {
                int rand = random();
                int x = rotation();
                int z = rotation();
                if (rand == 0) {
                    holder.setTransform((new AffineTransform()).rotateX(x));
                } else if (rand == 1) {
                    holder.setTransform((new AffineTransform()).rotateZ(z));
                } else {
                    holder.setTransform((new AffineTransform()).rotateX(x).rotateZ(z));
                }
            }
            Operation operation = holder.createPaste(editSession).to(BlockVector3.at(location.getBlockX(), location.getBlockY(), location.getBlockZ())).ignoreAirBlocks(true).build();
            Operations.complete(operation);
            editSession.flushSession();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WorldEditException e) {
            e.printStackTrace();
        }
    }
}
