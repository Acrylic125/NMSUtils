package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

public class NBTItem extends NBT {

    private ItemStack nmsItemStack;
    private final org.bukkit.inventory.ItemStack item;

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        this.item = item;
    }

    public org.bukkit.inventory.ItemStack getItem() {
        if (nmsItemStack == null) return item;
        nmsItemStack.setTag(getCompound().getCompound());
        return CraftItemStack.asBukkitCopy(nmsItemStack);
    }

    @Override
    public NBTCompound getCompound() {
        if (compound == null) {
            if (item == null || item.getType().equals(Material.AIR)) {
                this.nmsItemStack = null;
                super.setMainCompound(new NBTTagCompound());
            } else {
                this.nmsItemStack = CraftItemStack.asNMSCopy(item);
                super.setMainCompound(nmsItemStack.getTag());
            }
        }
        return compound;
    }
}
