package acrylic.nmsutils.NMSEntity;

import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import org.bukkit.Location;

/**
 * NMSEnttiyTeleport is a packet PacketManager subclass.
 */
public class NMSEntityTeleport extends PacketManager {

    private final Entity entity;

    public NMSEntityTeleport(Entity entity, Location location) {
        this.entity = entity;
        entity.setLocation(location.getX(),location.getY(),location.getZ(),location.getYaw(),location.getPitch());
    }

    /**
     *
     * @return Use the PacketManager.send(...) to send this
     *         packet.
     */
    @Override
    public Packet getPacket() {
        return new PacketPlayOutEntityTeleport(entity);
    }

}
