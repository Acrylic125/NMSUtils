package acrylic.nmsutils.NBTAPI;

import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

public class NBTItem extends NBT {

    private final ItemStack nmsItemStack;

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        this.nmsItemStack = CraftItemStack.asNMSCopy(item);
        super.setMainCompound(nmsItemStack.getTag());
    }

    public org.bukkit.inventory.ItemStack getItem() {
        nmsItemStack.setTag(super.getCompound().getCompound());
        return CraftItemStack.asBukkitCopy(nmsItemStack);
    }

}
