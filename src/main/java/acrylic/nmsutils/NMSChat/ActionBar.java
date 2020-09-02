package acrylic.nmsutils.NMSChat;

import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBar extends PacketManager {

    PacketPlayOutChat packet;

    @Override
    public Packet getPacket() {
        return packet;
    }

}
