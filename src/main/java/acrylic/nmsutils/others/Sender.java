package acrylic.nmsutils.others;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface Sender {

    void send(Player player);

    default void sendAll() {
        Bukkit.getOnlinePlayers().forEach(this::send);
    }

    default void sendAll(Location location, float radius) {
        final double r = radius * radius;
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player.getLocation().distanceSquared(location) <= r) {
                send(player);
            }
        });
    }

}
