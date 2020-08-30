package acrylic.nmsutils.NBTAPI.converter;

import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

public class Converter {

    public static World getWorld(org.bukkit.World world) {
        return getCraftWorld(world).getHandle();
    }

    public static CraftWorld getCraftWorld(org.bukkit.World world) {
        return ((CraftWorld) world);
    }

    public static ItemStack getItem(org.bukkit.inventory.ItemStack item) {
        return CraftItemStack.asNMSCopy(item);
    }

    public static org.bukkit.inventory.ItemStack getItem(ItemStack item) {
        return CraftItemStack.asBukkitCopy(item);
    }

}
