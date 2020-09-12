package acrylic.nmsutils.NBTAPI;

import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

public class NBTItem extends NBT {

    private final ItemStack nmsItemStack;

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        if (item == null || item.getType().equals(Material.AIR)) {
            this.nmsItemStack = null;
            super.setMainCompound(new NBTTagCompound());
            return;
        }
        this.nmsItemStack = CraftItemStack.asNMSCopy(item);
        super.setMainCompound(nmsItemStack.getTag());
    }

    public org.bukkit.inventory.ItemStack getItem() {
        if (nmsItemStack == null) return new org.bukkit.inventory.ItemStack(Material.AIR);
        nmsItemStack.setTag(super.getCompound().getCompound());
        return CraftItemStack.asBukkitCopy(nmsItemStack);
    }

}
