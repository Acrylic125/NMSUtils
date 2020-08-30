package acrylic.nmsutils.NBTAPI;

import acrylic.nmsutils.NBTAPI.converter.Converter;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntity;

public class NBTTileEntity extends NBT {

    private final TileEntity tileEntity;

    public NBTTileEntity(org.bukkit.block.Block block) {
        this.tileEntity = Converter.getCraftWorld(block.getWorld()).getTileEntityAt(block.getX(),block.getY(),block.getZ());
        NBTTagCompound compound = new NBTTagCompound();
        tileEntity.b(compound);
        super.setMainCompound(compound);
    }

    public void update() {
        tileEntity.a(super.getCompound().getCompound());
        tileEntity.update();
    }

}
