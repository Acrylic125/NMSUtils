package acrylic.nmsutils.NMSEntity;

import net.minecraft.server.v1_8_R3.Entity;
import org.bukkit.Location;

import java.util.ArrayList;

public interface NMSEntity {

    /**
     *
     * @return retrieves the NMS Entity of the animator.
     */
    Entity getNMSEntity();

    /**
     * Only for testing. Will be removed in the future.
     */
    @Deprecated
    NMSEntity spawn(Location location);

    /**
     *
     * @param location The location you want to teleport the animator
     *                 object.
     * @return Returns NMSEntityTeleport. Read the shit described in NMSEntityTeleport
     *                 before using this.
     */
    NMSEntityTeleport teleport(Location location);

    NMSEntityEquipment nmsEquipment();

    NMSEntityShow show();

    NMSEntity delete();

    ArrayList getDataPackets();

    NMSEntity setDataPackets(ArrayList packets);

}
