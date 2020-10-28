package acrylic.nmsutils.commands;

import acrylic.nmsutils.NBTAPI.NBTItem;
import acrylic.nmsutils.PacketManager;
import acrylic.nmsutils.json.AbstractJSON;
import acrylic.nmsutils.json.JSON;
import acrylic.nmsutils.json.JSONComponent;
import com.acrylic.version_latest.Messages.ChatUtils;
import lombok.SneakyThrows;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd implements CommandExecutor {

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        return true;
    }
}
