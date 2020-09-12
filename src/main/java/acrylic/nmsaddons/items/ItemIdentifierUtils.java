package acrylic.nmsaddons.items;

import acrylic.nmsutils.NBTAPI.NBTItem;
import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.inventory.ItemStack;

public class ItemIdentifierUtils {

    private static final String ITEM_MAIN_COMPOUND = "item";
    private static final String IDENTIFIER_TAG = "id";
    private static final String SUBIDENTIFIER_TAG = "subid";

    private final NBTItem nbtItem;
    private final NBTCompound compound;

    public ItemIdentifierUtils(NBTItem nbtItem) {
        this.nbtItem = nbtItem;
        compound = nbtItem.getCompound();
    }

    public ItemIdentifierUtils(ItemStack item) {
        this.nbtItem = new NBTItem(item);
        compound = nbtItem.getCompound();
    }

    public NBTCompound getItemCompound() {
        return compound;
    }

    public NBTCompound getCompound() {
        return compound.getCompound(ITEM_MAIN_COMPOUND);
    }

    public String getIdentifier() {
        return getCompound().getString(IDENTIFIER_TAG);
    }

    public String getSubIdentifier() {
        return getCompound().getString(SUBIDENTIFIER_TAG);
    }

    public ItemIdentifierUtils setIdentifier(String identifier) {
        getCompound().set(IDENTIFIER_TAG,identifier);
        return this;
    }

    public ItemIdentifierUtils setSubIdentifier(String subIdentifier) {
        getCompound().set(SUBIDENTIFIER_TAG,subIdentifier);
        return this;
    }

    public ItemStack getItem() {
        return nbtItem.getItem();
    }

}
