package acrylic.nmsutils.NMSEntity;

import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.EntityAnimators.Equipment.AbstractEntityEquipment;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityEquipment;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class NMSEntityEquipment extends PacketManager implements AbstractEntityEquipment {

    private Entity entity;
    private List<PacketPlayOutEntityEquipment> packets = new LinkedList<>();

    public NMSEntityEquipment(Entity entity) {
        this.entity = entity;
    }

    @Override
    public AbstractEntityEquipment setItemInMainHand(ItemStack itemStack) {
        packets.add(new PacketPlayOutEntityEquipment(entity.getId(),0, CraftItemStack.asNMSCopy(itemStack)));
        return this;
    }

    @Override
    public AbstractEntityEquipment setHelmet(ItemStack itemStack) {
        packets.add(new PacketPlayOutEntityEquipment(entity.getId(),4, CraftItemStack.asNMSCopy(itemStack)));
        return this;
    }

    @Override
    public AbstractEntityEquipment setChestplate(ItemStack itemStack) {
        packets.add(new PacketPlayOutEntityEquipment(entity.getId(),3, CraftItemStack.asNMSCopy(itemStack)));
        return this;
    }

    @Override
    public AbstractEntityEquipment setLeggings(ItemStack itemStack) {
        packets.add(new PacketPlayOutEntityEquipment(entity.getId(),2, CraftItemStack.asNMSCopy(itemStack)));
        return this;
    }

    @Override
    public AbstractEntityEquipment setBoots(ItemStack itemStack) {
        packets.add(new PacketPlayOutEntityEquipment(entity.getId(),1, CraftItemStack.asNMSCopy(itemStack)));
        return this;
    }

    @Override
    public AbstractEntityEquipment getInstance() {
        return this;
    }

    @Override
    public List getPackets() {
        return packets;
    }

}
