package acrylic.nmsutils.NMSEntity;

import com.acrylic.version_latest.Animations.Holograms;
import com.acrylic.version_latest.Messages.ChatUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class NMSHolograms extends Holograms {

    private LinkedList<NMSHologram> holograms = new LinkedList();
    private Location location;
    private final float yOffset;
    private Player player;

    public NMSHolograms(Location location, float yOffset, String... hologramText) {
        super(location, yOffset);
        this.location = super.getLocation();
        this.yOffset = yOffset;
        setup(hologramText);
    }

    public NMSHolograms(Player p, Location location, float yOffset, String... hologramText) {
        super(location, yOffset);
        this.location = super.getLocation();
        this.yOffset = yOffset;
        this.player = p;
        setup(hologramText);
    }

    private void setup(String... hologramText) {
        int maxLength = hologramText.length;
        for(int i = 0; i < maxLength; ++i) {
            String s = hologramText[i];
            if (!s.equals("")) {
                this.holograms.add(new NMSHologram(location, i, ChatUtils.get(s), yOffset,player));
            }
        }
    }

    @Override
    public void delete() {
        this.holograms.forEach((hologram) -> {
            hologram.getNmsArmorStandAnimator().delete();
        });
    }

    @Override
    public LinkedList getHolograms() {
        return holograms;
    }

}
