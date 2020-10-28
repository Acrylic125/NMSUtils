package acrylic.nmsutils.json;

import acrylic.nmsutils.others.Sender;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public interface AbstractJSON extends Sender, Cloneable {

    AbstractJSON append(AbstractJSONComponent component);

    String toJson();

    PacketPlayOutChat getPacket();

    AbstractJSON duplicate();

}
