package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import lombok.Getter;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public abstract class NBT {

    @Getter
    private NBTCompound compound;

    public void setMainCompound(NBTTagCompound nbtTagCompound) {
        compound = new NBTCompound(nbtTagCompound,null,null);
    }

}
