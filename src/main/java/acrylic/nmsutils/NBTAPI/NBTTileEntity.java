package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.converter.Converter;
import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntity;
import org.bukkit.block.Block;

public class NBTTileEntity extends NBT {

    private TileEntity tileEntity;
    private final Block block;

    public NBTTileEntity(Block block) {
        this.block = block;
    }

    public void update() {
        if (tileEntity == null) return;
        tileEntity.a(getCompound().getCompound());
        tileEntity.update();
    }

    @Override
    public NBTCompound getCompound() {
        if (compound == null) {
            this.tileEntity = Converter.getCraftWorld(block.getWorld()).getTileEntityAt(block.getX(),block.getY(),block.getZ());
            NBTTagCompound compound = new NBTTagCompound();
            tileEntity.b(compound);
            super.setMainCompound(compound);
        }
        return compound;
    }
}
