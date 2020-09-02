package acrylic.nmsutils.AcrylicMirror;

import acrylic.nmsutils.NMSEntity.NMSEntityShow;
import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.Animations.HandRotatorAnimation;
import com.acrylic.version_latest.Shapes.Circle;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.Vector3f;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import acrylic.nmsutils.NMSEntity.NMSArmorStandAnimator;

/**
 * This class ONLY SUPPORTS NMS ARMOR STANDS!
 * For Giants, please use the normal HandRotatorAnimation class.
 *
 * Please also read the documentations for HandRotatorAnimation if you need
 * any help.
 */
public class NMSHandRotatorAnimation extends HandRotatorAnimation implements NMSAnimatorDisplayer {

    @Getter
    private static final Vector3f DANGLE_EULER_ANGLE = new Vector3f(-100f, -40, 0);

    private final EntityArmorStand entity;
    @Getter
    private final NMSArmorStandAnimator nmsArmorStandAnimator;

    @Setter
    private Location location;

    @Setter @Getter
    private Player player;
    private int index = 0;

    public NMSHandRotatorAnimation(NMSArmorStandAnimator nmsArmorStandAnimator) {
        super(nmsArmorStandAnimator.getEntity());
        this.nmsArmorStandAnimator = nmsArmorStandAnimator;
        location = super.getLocation();
        entity = nmsArmorStandAnimator.getNMSEntity();
        this.entity.setRightArmPose(DANGLE_EULER_ANGLE);
    }

    @Override
    public void teleport(Location location) {
        this.location = location.clone();
        ++this.index;
        Circle circle = new Circle(this.armLength, location, 32.0F);
        Location loc = circle.getCirclePoint(this.index);
        Vector difference = this.location.toVector().subtract(loc.toVector());

        loc.setDirection(difference);
        if (player != null) {
            PacketManager.send(player,nmsArmorStandAnimator.teleport(loc).getPacket());
            return;
        }
        PacketManager.send(nmsArmorStandAnimator.teleport(loc).getPacket());
    }

    public Location getAnimatorStartingLocation() {
        Circle circle = new Circle(this.armLength, location, 32.0F);
        Location loc = circle.getCirclePoint(1);
        Vector difference = this.location.toVector().subtract(loc.toVector());
        loc.setDirection(difference);
        return loc;
    }

    @Override
    public NMSEntityShow getNMSEntityShow() {
        return getNmsArmorStandAnimator().show();
    }

}
