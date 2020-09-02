package acrylic.nmsutils.NMSEntity;

import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.Animations.Hologram;
import lombok.Getter;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Getter
public class NMSHologram extends Hologram {

    private final NMSArmorStandAnimator nmsArmorStandAnimator;
    private Player player;

    public NMSHologram(Location location, int index, String hologramText, float yOffset) {
        super(index, yOffset);
        nmsArmorStandAnimator = new NMSArmorStandAnimator(location.clone().add(0,super.getOffsetHeight(),0)).setSmall();
        EntityArmorStand animator = nmsArmorStandAnimator.getAnimator();
        animator.setCustomNameVisible(true);
        animator.setCustomName(hologramText);
        nmsArmorStandAnimator.show().showAll();
    }

    public NMSHologram(Location location, int index, String hologramText, float yOffset, Player player) {
        super(index, yOffset);
        this.player = player;
        nmsArmorStandAnimator = new NMSArmorStandAnimator(location.clone().add(0,super.getOffsetHeight(),0)).setSmall();
        EntityArmorStand animator = nmsArmorStandAnimator.getAnimator();
        animator.setCustomNameVisible(true);
        animator.setCustomName(hologramText);
        if (player != null) {
            nmsArmorStandAnimator.show().show(player);
        } else {
            nmsArmorStandAnimator.show().showAll();
        }
    }

    @Override
    public void teleport(Location location) {
        if (player != null) {
            PacketManager.send(player,nmsArmorStandAnimator.teleport(location).getPacket());
        } else {
            PacketManager.send(nmsArmorStandAnimator.teleport(location).getPacket());
        }
    }

    @Override
    public float getOffsetHeight() {
        return super.getOffsetHeight();
    }

}
