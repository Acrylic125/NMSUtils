package acrylic.nmsutils.AcrylicMirror;

import acrylic.nmsutils.NMSEntity.NMSEntityShow;
import acrylic.nmsutils.NMSEntity.NMSGiantAnimator;
import acrylic.nmsutils.PacketManager;
import com.acrylic.version_latest.Animations.HandRotatorAnimation;
import com.acrylic.version_latest.Shapes.Circle;
import net.minecraft.server.v1_8_R3.EntityGiantZombie;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * This class ONLY SUPPORTS NMS GIANTS!
 *
 * Please also read the documentations for HandRotatorAnimation if you need
 * any help.
 */
public class NMSGiantHandRotatorAnimation extends HandRotatorAnimation implements NMSAnimatorDisplayer {

    private final EntityGiantZombie entity;
    private final NMSGiantAnimator nmsGiantAnimator;

    private Location location;
    private int index = 0;

    public NMSGiantHandRotatorAnimation(NMSGiantAnimator nmsGiantAnimator) {
        super(nmsGiantAnimator.getEntity());
        this.nmsGiantAnimator = nmsGiantAnimator;
        location = super.getLocation();
        entity = nmsGiantAnimator.getNMSEntity();
    }

    @Override
    public void teleport(Location location) {
        this.location = location.clone();
        ++this.index;
        Circle circle = new Circle(this.armLength, location, 32.0F);
        Location loc = circle.getCirclePoint(this.index);
        Vector difference = this.location.toVector().subtract(loc.toVector());
        loc.setDirection(difference);
        loc.add((2F * circle.getSinTheta()), 0, (-2F * circle.getCosTheta()));
        PacketManager.send(nmsGiantAnimator.teleport(loc).getPacket());
    }

    @Override
    public NMSEntityShow getNMSEntityShow() {
        return nmsGiantAnimator.show();
    }
}
