package acrylic.nmsutils.NMSParticle;

import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NMSParticle extends PacketManager {

    private final EnumParticle particletype;
    private boolean longdistance = true;
    private Location location;
    private float speed = 0;
    private int amount = 1;

    private float offsetX = 0;
    private float offsetY = 0;
    private float offsetZ = 0;

    private float red = 0;
    private float green = 0;
    private float blue = 0;

    private PacketPlayOutWorldParticles packet;
    private net.minecraft.server.v1_8_R3.ItemStack item;

    public NMSParticle(EnumParticle particletype,Location location) {
        this.particletype = particletype;
        this.location = location;
    }

    public NMSParticle setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public NMSParticle setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public NMSParticle setLocation(Location location) {
        this.location = location;
        return this;
    }

    public NMSParticle build() {
        packet = (item != null) ? new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetX, this.offsetY, this.offsetZ, this.speed, this.amount, Item.getId(item.getItem()),item.getData()) :
                (particletype.equals(EnumParticle.REDSTONE)) ? new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float) this.location.getX(), (float) this.location.getY(), (float) this.location.getZ(), this.offsetX, this.offsetY, this.offsetZ, 0,  this.amount, 0) :
                  new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetX, this.offsetY, this.offsetZ, this.speed, this.amount);
        return this;
    }

    public NMSParticle setOffset(float offsetX, float offsetY, float offsetZ) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        return this;
    }

    public NMSParticle setOffset(float offset) {
        this.offsetX = offset;
        this.offsetY = offset;
        this.offsetZ = offset;
        return this;
    }

    public NMSParticle setItem(ItemStack item) {
        this.item = CraftItemStack.asNMSCopy(item);
        return this;
    }

    public NMSParticle setRGB(float red, float green, float blue) {
        this.red = red / 255;
        this.green = green / 255;
        this.blue = blue / 255;
        return this;
    }

    @Override
    public Packet getPacket() {
        return packet;
    }

}
