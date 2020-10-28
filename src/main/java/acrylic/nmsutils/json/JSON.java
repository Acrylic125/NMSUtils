package acrylic.nmsutils.json;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.entity.Player;

public final class JSON implements AbstractJSON, Cloneable {

    private final TextComponent textComponent;

    public JSON(AbstractJSONComponent component) {
        textComponent = new TextComponent(component.getTextComponent());
    }

    public JSON() {
        textComponent = new TextComponent("");
    }

    @Override
    public AbstractJSON append(AbstractJSONComponent component) {
        textComponent.addExtra(component.getTextComponent());
        return this;
    }

    @Override
    public void send(Player player) {
        player.spigot().sendMessage(textComponent);
    }

    @Override
    public String toJson() {
        return toString();
    }

    @Override
    public PacketPlayOutChat getPacket() {
        return new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a(toJson()));
    }

    @Override
    public String toString() {
        return ComponentSerializer.toString(textComponent);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
