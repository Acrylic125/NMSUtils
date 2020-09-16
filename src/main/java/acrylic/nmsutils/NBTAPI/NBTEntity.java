package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import net.minecraft.server.v1_8_R3.EntityLiving;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;

public class NBTEntity extends NBT {

    private net.minecraft.server.v1_8_R3.Entity entity;
    private final Entity originalEntity;

    public NBTEntity(Entity entity) {
        originalEntity = entity;
    }

    public void update() {
        if (entity instanceof EntityLiving) ((EntityLiving) entity).a(getCompound().getCompound());
    }

    @Override
    public NBTCompound getCompound() {
        if (compound == null) {
            this.entity = ((CraftEntity) originalEntity).getHandle();
            super.setMainCompound(this.entity.getNBTTag());
        }
        return compound;
    }
}
