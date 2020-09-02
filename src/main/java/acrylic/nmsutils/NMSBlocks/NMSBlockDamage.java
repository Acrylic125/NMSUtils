package acrylic.nmsutils.NMSBlocks;

import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockBreakAnimation;
import org.bukkit.block.Block;

public class NMSBlockDamage extends PacketManager {

    PacketPlayOutBlockBreakAnimation packet;

    public NMSBlockDamage(Block block, int identifier, int damage) {
        packet = new PacketPlayOutBlockBreakAnimation(identifier, new BlockPosition(block.getX(), block.getY(), block.getZ()), damage);
    }

    /**
     *
     * @return Use the PacketManager.send(...) to send this
     *         packet.
     */
    @Override
    public Packet getPacket() {
        return packet;
    }


}
