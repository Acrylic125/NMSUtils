package acrylic.nmsutils.commands;

import acrylic.nmsutils.NBTAPI.NBTEntity;
import acrylic.nmsutils.NBTAPI.NBTItem;
import acrylic.nmsutils.NBTAPI.NBTTileEntity;
import acrylic.nmsutils.NBTAPI.modifiers.NBTCompound;
import net.minecraft.server.v1_8_R3.NBTTagFloat;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        return true;
    }
}
