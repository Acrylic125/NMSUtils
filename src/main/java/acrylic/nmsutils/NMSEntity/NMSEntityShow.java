package acrylic.nmsutils.NMSEntity;

import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class NMSEntityShow {

    private final Entity entity;
    private final NMSEntity nmsEntity;

    private final ArrayList packets;

    public NMSEntityShow(NMSEntity nmsEntity, Entity entity) {
        this.entity = entity;
        this.nmsEntity = nmsEntity;
        ArrayList dataPackets = nmsEntity.getDataPackets();

        PacketPlayOutSpawnEntityLiving spawnPacket = new PacketPlayOutSpawnEntityLiving((EntityLiving) this.entity);
        packets = new ArrayList();
        if (dataPackets == null) {
            dataPackets = new ArrayList();
            if (nmsEntity instanceof NMSArmorStandAnimator) {
                dataPackets.add(new PacketPlayOutEntityMetadata(entity.getId(),entity.getDataWatcher(),false));
            }
            if (nmsEntity.nmsEquipment() != null) {
                dataPackets.addAll(nmsEntity.nmsEquipment().getPackets());
            }
            nmsEntity.setDataPackets(dataPackets);
        }
        packets.add(spawnPacket);
        packets.addAll(dataPackets);
    }

    public void showNearby() {
        showNearby(32);
    }

    public void showNearby(int radius) {
        PacketManager.send(entity.getBukkitEntity().getNearbyEntities(radius,radius,radius),packets);
    }

    public void show(Player player) {
        PacketManager.send(player,packets);
    }

    public void showAll() {
        PacketManager.send(packets);
    }

}
