package acrylic.nmsutils.AcrylicMirror;

import acrylic.nmsutils.NMSEntity.NMSEntityShow;
import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.Animations.HeadRotatorAnimation;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.Vector3f;
import org.bukkit.Location;
import org.bukkit.util.EulerAngle;
import acrylic.nmsutils.NMSEntity.NMSArmorStandAnimator;

/**
 * This class ONLY SUPPORTS NMS ARMOR STANDS!
 *
 * Please also read the documentations for HeadRotatorAnimation if you need
 * any help.
 */
public class NMSHeadRotatorAnimation extends HeadRotatorAnimation implements NMSAnimatorDisplayer {

    private static final Vector3f TILTED_EULER_ANGLE = new Vector3f(-40, 0, 0);
    private static final float K = (float) (180 / Math.PI);

    private final EntityArmorStand entity;
    private final NMSArmorStandAnimator nmsArmorStandAnimator;

    private Location location;
    private float rotation = 15.0F;
    private int index = 0;

    public NMSHeadRotatorAnimation(NMSArmorStandAnimator nmsArmorStandAnimator) {
        super(nmsArmorStandAnimator.getEntity());
        this.nmsArmorStandAnimator = nmsArmorStandAnimator;
        location = super.getLocation();
        entity = nmsArmorStandAnimator.getNMSEntity();
    }

    @Override
    public NMSHeadRotatorAnimation setTilted() {
        this.entity.setHeadPose(TILTED_EULER_ANGLE);
        return this;
    }

    @Override
    public NMSHeadRotatorAnimation setTilted(EulerAngle eulerAngle) {
        this.entity.setHeadPose(new Vector3f((float) eulerAngle.getX() * K,(float) eulerAngle.getY() * K,(float) eulerAngle.getZ() * K));
        return this;
    }

    @Override
    public void teleport(Location location) {
        float yaw = this.rotation * (float)this.index;
        location.setYaw(yaw);
        PacketManager.send(nmsArmorStandAnimator.teleport(location).getPacket());
        ++this.index;
    }

    @Override
    public NMSEntityShow getNMSEntityShow() {
        return nmsArmorStandAnimator.show();
    }

}
