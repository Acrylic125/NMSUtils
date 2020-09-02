package acrylic.nmsutils.NMSBlocks;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.inventory.ItemStack;

public class NMSSetBlock {

    public static void setBlockInNativeWorld(Location location, org.bukkit.Material material,int dmg) {
        World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        BlockPosition bp = new BlockPosition(location.getX(), location.getY(), location.getZ());
        IBlockData ibd = Block.getByCombinedId(material.getId() + (dmg << 12));
        nmsWorld.setTypeAndData(bp, ibd, 2);
    }

    public static void setBlockInNativeWorld(Location location, ItemStack item) {
        setBlockInNativeWorld(location,item.getType(),item.getDurability());
    }

    public static void setBlockInNativeChunk(Location location,ItemStack item) {
        net.minecraft.server.v1_8_R3.World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        net.minecraft.server.v1_8_R3.Chunk nmsChunk = nmsWorld.getChunkAt(location.getBlockX() >> 4, location.getBlockZ() >> 4);
        BlockPosition bp = new BlockPosition(location.getX(), location.getY(), location.getZ());
        IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(item.getTypeId() + (item.getDurability() << 12));

        nmsChunk.a(bp,ibd);
    }


}
