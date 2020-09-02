package acrylic.nmsutils;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import acrylic.nmsutils.NMSEntity.Exceptions.UnsupportedPacketGetter;

import java.util.List;

/**
 * RAW NMS SYSTEM!
 * Packet Manager class.
 */
public abstract class PacketManager {

    public Packet getPacket() {
        throw new UnsupportedPacketGetter("There are multiple packets. Try using #.getPackets()");
    }

    public List<Packet> getPackets() {
        throw new UnsupportedPacketGetter("There is only 1 packet. Try using #.getPacket()");
    }

    /**
     * Player references
     */
    public static EntityPlayer getCraftPlayer(Player p) {
        return ((CraftPlayer) p).getHandle();
    }

    public static PlayerConnection getPlayerConnection(Player p) {
        return getCraftPlayer(p).playerConnection;
    }

    /**
     * Packet senders.
     */
    public static void send(Player p,Packet packet) {
        getPlayerConnection(p).sendPacket(packet);
    }

    public static void send(List<Entity> players, Packet packet) {
        players.forEach(player -> {
            if (player instanceof Player) {
                send((Player) player, packet);
            }
        });
    }

    public static void send(Packet packet) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            send(player,packet);
        });
    }

    public static void send(Player p,List packets) {
        PlayerConnection connection = getPlayerConnection(p);
        packets.forEach(packet -> {
            if (packet instanceof Packet) {
                connection.sendPacket((Packet) packet);
            }
        });
    }

    public static void send(List<Entity> players, List packets) {
        players.forEach(player -> {
            if (player instanceof Player) {
                send((Player) player, packets);
            }
        });
    }

    public static void send(List packets) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            send(player,packets);
        });
    }

}
