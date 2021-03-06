package acrylic.nmsutils;

import acrylic.nmsutils.commands.Cmd;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This utilities is meant for Version 1.8
 *
 * As this system does not use reflection this is only optimised and usable
 * for 1 version, 1.8.8_R1.
 */
public final class NMSUtils extends JavaPlugin {

    @Getter
    private static NMSUtils instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.getCommand("cmd").setExecutor(new Cmd());
    }

}
