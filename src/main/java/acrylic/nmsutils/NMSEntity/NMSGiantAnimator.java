package acrylic.nmsutils.NMSEntity;

import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.EntityAnimators.EntityAnimator;
import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_8_R3.EntityGiantZombie;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import acrylic.nmsutils.NMSEntity.Exceptions.NotNMSSupportedException;

import java.util.ArrayList;

public class NMSGiantAnimator implements EntityAnimator, NMSEntity {
    @Getter
    private EntityGiantZombie animator;
    private NMSEntityEquipment nmsEntityEquipment;
    @Setter @Getter
    private ArrayList packets = null;

    public NMSGiantAnimator(Location location) {
        animator = new EntityGiantZombie(((CraftWorld) location.getWorld()).getHandle());
        animator.setLocation(location.getX(),location.getY(),location.getZ(),location.getYaw(),location.getPitch());
        animator.setInvisible(true);
        animator.ai = false;
        animator.setCustomName("Dinnerbone");
    }

    @Override
    public EntityAnimator setEntityEquipment(AbstractEntityEquipment abstractEntityEquipment) {
        if (abstractEntityEquipment instanceof NMSEntityEquipment) {
            nmsEntityEquipment = (NMSEntityEquipment) abstractEntityEquipment;
            return this;
        }
        throw new NotNMSSupportedException("AbstractEntityEquipment must be an NMSEntityEquipment!");
    }

    @Override
    public NMSEntityEquipment getEntityEquipment() {
        return nmsEntityEquipment;
    }

    @Override
    public EntityAnimator getInstance() {
        return this;
    }

    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) animator.getBukkitEntity();
    }

    @Override
    public EntityGiantZombie getNMSEntity() {
        return animator;
    }

    @Override
    public NMSEntity spawn(Location location) {
        return null;
    }

    @Override
    public NMSEntityTeleport teleport(Location location) {
       return new NMSEntityTeleport(animator,location);
    }

    @Override
    public NMSEntityEquipment nmsEquipment() {
        return nmsEntityEquipment;
    }

    @Override
    public NMSEntityShow show() {
        return new NMSEntityShow(this,animator);
    }

    @Override
    public NMSEntity delete() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            PacketManager.send(player,new PacketPlayOutEntityDestroy(animator.getId()));
        });
        getEntity().remove();
        return this;
    }

    @Override
    public ArrayList getDataPackets() {
        return packets;
    }

    @Override
    public NMSEntity setDataPackets(ArrayList packets) {
        this.packets = packets;
        return this;
    }

}
