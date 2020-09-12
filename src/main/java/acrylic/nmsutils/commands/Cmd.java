package acrylic.nmsutils.commands;

import acrylic.nmsaddons.items.ItemIdentifierUtils;
import acrylic.nmsutils.NBTAPI.NBTItem;
import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import acrylic.nmsutils.NMSParticle.NMSParticle;
import acrylic.nmsutils.NMSUtils;
import acrylic.nmsutils.PacketManager;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

         return true;
    }
}
