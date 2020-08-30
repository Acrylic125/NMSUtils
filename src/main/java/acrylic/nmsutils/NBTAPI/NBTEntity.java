package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.converter.Converter;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;

public class NBTEntity extends NBT {

    private final net.minecraft.server.v1_8_R3.Entity entity;

    public NBTEntity(Entity entity) {
        this.entity = ((CraftEntity) entity).getHandle();
        super.setMainCompound(this.entity.getNBTTag());
    }

    public void update() {
        if (entity instanceof EntityLiving) ((EntityLiving) entity).a(super.getCompound().getCompound());
    }


}
